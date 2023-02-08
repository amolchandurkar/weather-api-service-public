package com.aac.learning.weather.weatherapispringboot.rest.controller;

import com.aac.learning.weather.weatherapispringboot.rest.model.ForecastResponse;
import com.aac.learning.weather.weatherapispringboot.rest.services.WeatherAPIService;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@Validated
public class WeatherAPIForcastController {
    private WeatherAPIService weatherAPIService;

    public WeatherAPIForcastController(WeatherAPIService weatherAPIService){
        this.weatherAPIService = weatherAPIService;
    }

    @GetMapping(
            value={"/api/weather-forecast/{city}"},
            produces = {"application/json"}
    )
    public ResponseEntity<ForecastResponse> getWeatherForecast(@PathVariable("city") @NonNull String city){
            ForecastResponse forecastResponse = weatherAPIService.getWeatherForecast(city);
            return ResponseEntity.status(forecastResponse.getResponseCode()).body(forecastResponse);
    }
}
