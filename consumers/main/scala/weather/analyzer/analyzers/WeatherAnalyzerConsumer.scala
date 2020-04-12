package weather.analyzer.analyzers

import java.time.Duration
import java.util
import java.util.Properties

import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig
import org.apache.kafka.clients.consumer._
import org.apache.kafka.common.TopicPartition
import org.apache.kafka.common.errors.WakeupException
import weather.analyzer.models.WeatherData

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Future, blocking}
import scala.io.StdIn
import scala.jdk.CollectionConverters._


object WeatherAnalyzerConsumer {

  def main(args: Array[String]): Unit = {

    val props = new Properties()

    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "http://localhost:9091,http://localhost:9092,http://localhost:9093")
    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer")
    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, classOf[io.confluent.kafka.serializers.KafkaAvroDeserializer])
    props.put(ConsumerConfig.GROUP_ID_CONFIG, args.lift(1).getOrElse("weather-consumer"))
    props.put("schema.registry.url", "http://localhost:8081")
    props.put(KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG, "true")

    val consumer = new KafkaConsumer[String, WeatherData](props)

    try {
      setupShutdown(consumer)
      val topic = "weather"
      consumer.subscribe(Seq(topic).asJava, new ConsumerRebalanceListener {
        override def onPartitionsRevoked(partitions: util.Collection[TopicPartition]): Unit = {
          println("Lost the following Partitions: ")
          partitions.forEach(println)
        }

        override def onPartitionsAssigned(partitions: util.Collection[TopicPartition]): Unit = {
          println("Gained the following Partitions: ")
          partitions.forEach(println)
        }
      })

      while (true) {
        val timeToWaitForData = Duration.ofSeconds(1)
        val weatherRecords: ConsumerRecords[String, WeatherData] = consumer.poll(timeToWaitForData)
        weatherRecords.asScala
          .groupBy(weatherData => weatherData.value.getLocation)
          .foreach {
            case (location, weatherList) =>
              val dataSortedWeatherList = weatherList.toSeq.sortBy(weatherData => weatherData.value.getEpoch)

              dataSortedWeatherList.sliding(5, 5).foreach((weatherChunk: Seq[ConsumerRecord[String, WeatherData]]) => {
                val value = weatherChunk.map(_.value)
                printWhetherAscendingOrDescending(value)
                value.foreach { v => println(s"Processed weather chunk containing '$v") }

              })
          }

        Thread.sleep(5000)
      }
    } catch {
      case _: WakeupException =>
    } finally {
      consumer.close()
      println("Shutting down")
    }
  }

  private def isAscending(temperatures: Seq[Integer]): Boolean = {
    temperatures.sliding(2).forall {
      case Seq() => true
      case Seq(_) => true
      case Seq(first, second) => first <= second
    }
  }

  private def isDescending(temperatures: Seq[Integer]): Boolean = {
    temperatures.sliding(2).forall {
      case Seq() => true
      case Seq(_) => true
      case Seq(first, second) => first >= second
    }
  }

  private def printWhetherAscendingOrDescending(weatherDatas: Seq[WeatherData]): Unit = {
    val temperatures = weatherDatas.map(weatherData => weatherData.getTemperature)
    val location = weatherDatas.head.getLocation
    if (isAscending(temperatures)) println(s"Temperatures in location $location are on the rise")
    else if (isDescending(temperatures)) println(s"It's getting colder in $location.")
    else println(s"Temperatures are stagnating in $location")
  }

  private def setupShutdown(consumer: KafkaConsumer[_, _]) = {
    val mainThread = Thread.currentThread
    Runtime.getRuntime.addShutdownHook(new Thread {
      override def run(): Unit = {
        consumer.wakeup()
        try {
          mainThread.join()
        } catch {
          case ex: Throwable => println(s"Exception caught waiting for main thread to complete: $ex")
        }
      }
    })

    Future {
      blocking {
        Thread.sleep(5000)
      }
    }

    Future {
      blocking {
        if (StdIn.readLine(">>>Press [ENTER] to shut down consumer down\n") != null) {
          consumer.wakeup()
          System.exit(0)
        }
      }
    }
  }


}
