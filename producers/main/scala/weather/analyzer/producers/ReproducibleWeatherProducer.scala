package weather.analyzer.producers

import java.time.{ZoneId, ZonedDateTime}
import java.util.Properties
import java.util.concurrent.Future

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerConfig, ProducerRecord, RecordMetadata}
import weather.analyzer.models.WeatherData

import scala.collection.immutable.ListMap

object ReproducibleWeatherProducer {

  val locationMappedToTempInFRanges= ListMap(
    "Pittsburgh-PA-US" -> (65 to 95),
    "San Francisco-CA-US" -> (50 to 80),
    "Sydney-NSW-AU" -> (45 to 75),
    "Mumbai-NH-IN" -> (70 to 100),
    "London-UK-GB" -> (40 to 75)
  )

  val locationHourOffset = Seq(0, -3, 14, 9, 6)
  val weatherTypes = Seq(
    "Sunny",
    "Cloudy",
    "Fog",
    "Rain",
    "Lightning",
    "Windy"
  )
  val humidities = 30 to 100
  val windSpeedInMPHs = 0 to 20

  val startingDateTime = ZonedDateTime.of(
    2020, 3, 20,
    0, 0, 0, 0,
    ZoneId.of("Europe/London")
  )


  def main(args: Array[String]): Unit = {
    val props = new Properties()
    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "http://localhost:9091,http://localhost:9092,http://localhost:9093")
    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer")
    props.put("schema.registry.url", "http://localhost:8081")
    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, classOf[io.confluent.kafka.serializers.KafkaAvroSerializer])
    props.put(ProducerConfig.CLIENT_DNS_LOOKUP_CONFIG, "use_all_dns_ips")

    val producer = new KafkaProducer[String, WeatherData](props)

    try {
      println(">>>Press [ENTER] to sut the producer down")
      val topic = "weather"
      var currentGeneration = 0
      var currentDateTime = startingDateTime
      while (System.in.available == 0) {
        val delayUntilNextSend = 1000
        Thread.sleep(delayUntilNextSend)
        val currentWeatherStrings = generateWeatherStringsFor(currentGeneration, currentDateTime)
        currentWeatherStrings.foreach(
          currentWeatherString => {
            val (location, weatherData) = currentWeatherString
            val weatherRecord = new ProducerRecord[String, WeatherData](topic, s"ReproducibleWeatherSource__$location", weatherData)
            val resultFuture: Future[RecordMetadata] = producer.send(weatherRecord, (metadata: RecordMetadata, exception: Exception) => {
              if (exception != null) {
                println(s"Metadata is '$metadata' for error encountered when sending weather record: $exception")
              }
            })

            val metaDataResult: RecordMetadata = resultFuture.get
            println(s"Blocking until completion yields the same Metadata of $metaDataResult")
          }
        )
        currentWeatherStrings.foreach(println)
        currentGeneration = currentGeneration + 1
        currentDateTime = currentDateTime.plusHours(1)
      }
    } finally {
      producer.close()
    }
  }

  def generateWeatherStringsFor(currentGeneration: Int, currentDateTime: ZonedDateTime): Iterable[(String, WeatherData)] = {
    for (
      (locationMappedToTempInFRanges1, index) <- locationMappedToTempInFRanges.zipWithIndex
    ) yield {
      val builder = WeatherData.newBuilder();
      val (location, tempsInF) = locationMappedToTempInFRanges1


      val currentDay = currentGeneration / 24
      val baseCurrentHour = Math.floorMod(currentGeneration + locationHourOffset(index), 24)
      val hour = if (baseCurrentHour > 12) 12 - (baseCurrentHour % 12) else baseCurrentHour
      val currentTempIndex = (hour + currentDay) % tempsInF.size

      builder.setEpoch(currentDateTime.toEpochSecond)
      builder.setLocation(location)
      builder.setTemperature( tempsInF(currentTempIndex))
      builder.setWeather( weatherTypes((currentDay + index) % weatherTypes.size))
      builder.setWindSpeedInMPH( windSpeedInMPHs((currentDay + baseCurrentHour + index) % windSpeedInMPHs.size))
      builder.setHumidity( (currentDay + baseCurrentHour + index) % humidities.size)

      (location, builder.build())
    }
  }
}
