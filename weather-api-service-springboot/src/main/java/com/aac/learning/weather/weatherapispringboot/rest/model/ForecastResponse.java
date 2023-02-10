package com.aac.learning.weather.weatherapispringboot.rest.model;

import com.aac.learning.weather.weatherapispringboot.rest.utils.EmptyListFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY, valueFilter = EmptyListFilter.class)
public class ForecastResponse {
  @JsonProperty("cod")
  private int responseCode;

  @JsonProperty("message")
  private String message;

  @JsonProperty("cnt")
  private int count;
  // @JsonInclude(JsonInclude.Include.NON_NULL)
  // @JsonInclude(JsonInclude.Include.NON_EMPTY)
  @JsonProperty("list")
  private List<Forecast> forecasts;

  @JsonProperty("city")
  private City city;

  public ForecastResponse(
      int responseCode, String message, int count, List<Forecast> forecasts, City city) {
    this.responseCode = responseCode;
    this.message = message;
    this.count = count;
    this.forecasts = forecasts;
    this.city = city;
  }

  public ForecastResponse() {}

  public int getResponseCode() {
    return responseCode;
  }

  public String getMessage() {
    return message;
  }

  public int getCount() {
    return count;
  }

  @JsonIgnore
  public List<Forecast> getForecasts() {
    return forecasts;
  }

  public City getCity() {
    return city;
  }
}
