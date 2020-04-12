/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package weather.analyzer.models;

import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class WeatherData extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -4649604620342635770L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"WeatherData\",\"namespace\":\"weather.analyzer.models\",\"fields\":[{\"name\":\"epoch\",\"type\":\"long\"},{\"name\":\"location\",\"type\":\"string\"},{\"name\":\"temperature\",\"type\":\"int\"},{\"name\":\"weather\",\"type\":\"string\"},{\"name\":\"humidity\",\"type\":\"int\"},{\"name\":\"windSpeedInMPH\",\"type\":\"int\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public long epoch;
  @Deprecated public java.lang.CharSequence location;
  @Deprecated public int temperature;
  @Deprecated public java.lang.CharSequence weather;
  @Deprecated public int humidity;
  @Deprecated public int windSpeedInMPH;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public WeatherData() {}

  /**
   * All-args constructor.
   * @param epoch The new value for epoch
   * @param location The new value for location
   * @param temperature The new value for temperature
   * @param weather The new value for weather
   * @param humidity The new value for humidity
   * @param windSpeedInMPH The new value for windSpeedInMPH
   */
  public WeatherData(java.lang.Long epoch, java.lang.CharSequence location, java.lang.Integer temperature, java.lang.CharSequence weather, java.lang.Integer humidity, java.lang.Integer windSpeedInMPH) {
    this.epoch = epoch;
    this.location = location;
    this.temperature = temperature;
    this.weather = weather;
    this.humidity = humidity;
    this.windSpeedInMPH = windSpeedInMPH;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return epoch;
    case 1: return location;
    case 2: return temperature;
    case 3: return weather;
    case 4: return humidity;
    case 5: return windSpeedInMPH;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: epoch = (java.lang.Long)value$; break;
    case 1: location = (java.lang.CharSequence)value$; break;
    case 2: temperature = (java.lang.Integer)value$; break;
    case 3: weather = (java.lang.CharSequence)value$; break;
    case 4: humidity = (java.lang.Integer)value$; break;
    case 5: windSpeedInMPH = (java.lang.Integer)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'epoch' field.
   * @return The value of the 'epoch' field.
   */
  public java.lang.Long getEpoch() {
    return epoch;
  }

  /**
   * Sets the value of the 'epoch' field.
   * @param value the value to set.
   */
  public void setEpoch(java.lang.Long value) {
    this.epoch = value;
  }

  /**
   * Gets the value of the 'location' field.
   * @return The value of the 'location' field.
   */
  public java.lang.CharSequence getLocation() {
    return location;
  }

  /**
   * Sets the value of the 'location' field.
   * @param value the value to set.
   */
  public void setLocation(java.lang.CharSequence value) {
    this.location = value;
  }

  /**
   * Gets the value of the 'temperature' field.
   * @return The value of the 'temperature' field.
   */
  public java.lang.Integer getTemperature() {
    return temperature;
  }

  /**
   * Sets the value of the 'temperature' field.
   * @param value the value to set.
   */
  public void setTemperature(java.lang.Integer value) {
    this.temperature = value;
  }

  /**
   * Gets the value of the 'weather' field.
   * @return The value of the 'weather' field.
   */
  public java.lang.CharSequence getWeather() {
    return weather;
  }

  /**
   * Sets the value of the 'weather' field.
   * @param value the value to set.
   */
  public void setWeather(java.lang.CharSequence value) {
    this.weather = value;
  }

  /**
   * Gets the value of the 'humidity' field.
   * @return The value of the 'humidity' field.
   */
  public java.lang.Integer getHumidity() {
    return humidity;
  }

  /**
   * Sets the value of the 'humidity' field.
   * @param value the value to set.
   */
  public void setHumidity(java.lang.Integer value) {
    this.humidity = value;
  }

  /**
   * Gets the value of the 'windSpeedInMPH' field.
   * @return The value of the 'windSpeedInMPH' field.
   */
  public java.lang.Integer getWindSpeedInMPH() {
    return windSpeedInMPH;
  }

  /**
   * Sets the value of the 'windSpeedInMPH' field.
   * @param value the value to set.
   */
  public void setWindSpeedInMPH(java.lang.Integer value) {
    this.windSpeedInMPH = value;
  }

  /**
   * Creates a new WeatherData RecordBuilder.
   * @return A new WeatherData RecordBuilder
   */
  public static weather.analyzer.models.WeatherData.Builder newBuilder() {
    return new weather.analyzer.models.WeatherData.Builder();
  }

  /**
   * Creates a new WeatherData RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new WeatherData RecordBuilder
   */
  public static weather.analyzer.models.WeatherData.Builder newBuilder(weather.analyzer.models.WeatherData.Builder other) {
    return new weather.analyzer.models.WeatherData.Builder(other);
  }

  /**
   * Creates a new WeatherData RecordBuilder by copying an existing WeatherData instance.
   * @param other The existing instance to copy.
   * @return A new WeatherData RecordBuilder
   */
  public static weather.analyzer.models.WeatherData.Builder newBuilder(weather.analyzer.models.WeatherData other) {
    return new weather.analyzer.models.WeatherData.Builder(other);
  }

  /**
   * RecordBuilder for WeatherData instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<WeatherData>
    implements org.apache.avro.data.RecordBuilder<WeatherData> {

    private long epoch;
    private java.lang.CharSequence location;
    private int temperature;
    private java.lang.CharSequence weather;
    private int humidity;
    private int windSpeedInMPH;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(weather.analyzer.models.WeatherData.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.epoch)) {
        this.epoch = data().deepCopy(fields()[0].schema(), other.epoch);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.location)) {
        this.location = data().deepCopy(fields()[1].schema(), other.location);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.temperature)) {
        this.temperature = data().deepCopy(fields()[2].schema(), other.temperature);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.weather)) {
        this.weather = data().deepCopy(fields()[3].schema(), other.weather);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.humidity)) {
        this.humidity = data().deepCopy(fields()[4].schema(), other.humidity);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.windSpeedInMPH)) {
        this.windSpeedInMPH = data().deepCopy(fields()[5].schema(), other.windSpeedInMPH);
        fieldSetFlags()[5] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing WeatherData instance
     * @param other The existing instance to copy.
     */
    private Builder(weather.analyzer.models.WeatherData other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.epoch)) {
        this.epoch = data().deepCopy(fields()[0].schema(), other.epoch);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.location)) {
        this.location = data().deepCopy(fields()[1].schema(), other.location);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.temperature)) {
        this.temperature = data().deepCopy(fields()[2].schema(), other.temperature);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.weather)) {
        this.weather = data().deepCopy(fields()[3].schema(), other.weather);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.humidity)) {
        this.humidity = data().deepCopy(fields()[4].schema(), other.humidity);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.windSpeedInMPH)) {
        this.windSpeedInMPH = data().deepCopy(fields()[5].schema(), other.windSpeedInMPH);
        fieldSetFlags()[5] = true;
      }
    }

    /**
      * Gets the value of the 'epoch' field.
      * @return The value.
      */
    public java.lang.Long getEpoch() {
      return epoch;
    }

    /**
      * Sets the value of the 'epoch' field.
      * @param value The value of 'epoch'.
      * @return This builder.
      */
    public weather.analyzer.models.WeatherData.Builder setEpoch(long value) {
      validate(fields()[0], value);
      this.epoch = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'epoch' field has been set.
      * @return True if the 'epoch' field has been set, false otherwise.
      */
    public boolean hasEpoch() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'epoch' field.
      * @return This builder.
      */
    public weather.analyzer.models.WeatherData.Builder clearEpoch() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'location' field.
      * @return The value.
      */
    public java.lang.CharSequence getLocation() {
      return location;
    }

    /**
      * Sets the value of the 'location' field.
      * @param value The value of 'location'.
      * @return This builder.
      */
    public weather.analyzer.models.WeatherData.Builder setLocation(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.location = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'location' field has been set.
      * @return True if the 'location' field has been set, false otherwise.
      */
    public boolean hasLocation() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'location' field.
      * @return This builder.
      */
    public weather.analyzer.models.WeatherData.Builder clearLocation() {
      location = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'temperature' field.
      * @return The value.
      */
    public java.lang.Integer getTemperature() {
      return temperature;
    }

    /**
      * Sets the value of the 'temperature' field.
      * @param value The value of 'temperature'.
      * @return This builder.
      */
    public weather.analyzer.models.WeatherData.Builder setTemperature(int value) {
      validate(fields()[2], value);
      this.temperature = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'temperature' field has been set.
      * @return True if the 'temperature' field has been set, false otherwise.
      */
    public boolean hasTemperature() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'temperature' field.
      * @return This builder.
      */
    public weather.analyzer.models.WeatherData.Builder clearTemperature() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'weather' field.
      * @return The value.
      */
    public java.lang.CharSequence getWeather() {
      return weather;
    }

    /**
      * Sets the value of the 'weather' field.
      * @param value The value of 'weather'.
      * @return This builder.
      */
    public weather.analyzer.models.WeatherData.Builder setWeather(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.weather = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'weather' field has been set.
      * @return True if the 'weather' field has been set, false otherwise.
      */
    public boolean hasWeather() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'weather' field.
      * @return This builder.
      */
    public weather.analyzer.models.WeatherData.Builder clearWeather() {
      weather = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'humidity' field.
      * @return The value.
      */
    public java.lang.Integer getHumidity() {
      return humidity;
    }

    /**
      * Sets the value of the 'humidity' field.
      * @param value The value of 'humidity'.
      * @return This builder.
      */
    public weather.analyzer.models.WeatherData.Builder setHumidity(int value) {
      validate(fields()[4], value);
      this.humidity = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'humidity' field has been set.
      * @return True if the 'humidity' field has been set, false otherwise.
      */
    public boolean hasHumidity() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'humidity' field.
      * @return This builder.
      */
    public weather.analyzer.models.WeatherData.Builder clearHumidity() {
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'windSpeedInMPH' field.
      * @return The value.
      */
    public java.lang.Integer getWindSpeedInMPH() {
      return windSpeedInMPH;
    }

    /**
      * Sets the value of the 'windSpeedInMPH' field.
      * @param value The value of 'windSpeedInMPH'.
      * @return This builder.
      */
    public weather.analyzer.models.WeatherData.Builder setWindSpeedInMPH(int value) {
      validate(fields()[5], value);
      this.windSpeedInMPH = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'windSpeedInMPH' field has been set.
      * @return True if the 'windSpeedInMPH' field has been set, false otherwise.
      */
    public boolean hasWindSpeedInMPH() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'windSpeedInMPH' field.
      * @return This builder.
      */
    public weather.analyzer.models.WeatherData.Builder clearWindSpeedInMPH() {
      fieldSetFlags()[5] = false;
      return this;
    }

    @Override
    public WeatherData build() {
      try {
        WeatherData record = new WeatherData();
        record.epoch = fieldSetFlags()[0] ? this.epoch : (java.lang.Long) defaultValue(fields()[0]);
        record.location = fieldSetFlags()[1] ? this.location : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.temperature = fieldSetFlags()[2] ? this.temperature : (java.lang.Integer) defaultValue(fields()[2]);
        record.weather = fieldSetFlags()[3] ? this.weather : (java.lang.CharSequence) defaultValue(fields()[3]);
        record.humidity = fieldSetFlags()[4] ? this.humidity : (java.lang.Integer) defaultValue(fields()[4]);
        record.windSpeedInMPH = fieldSetFlags()[5] ? this.windSpeedInMPH : (java.lang.Integer) defaultValue(fields()[5]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  private static final org.apache.avro.io.DatumWriter
    WRITER$ = new org.apache.avro.specific.SpecificDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  private static final org.apache.avro.io.DatumReader
    READER$ = new org.apache.avro.specific.SpecificDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
