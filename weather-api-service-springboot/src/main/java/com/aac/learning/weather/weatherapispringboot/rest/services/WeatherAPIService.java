package com.aac.learning.weather.weatherapispringboot.rest.services;

import com.aac.learning.weather.weatherapispringboot.core.logging.api.ServiceLogger;
import com.aac.learning.weather.weatherapispringboot.core.logging.api.ServiceLoggerFactory;
import com.aac.learning.weather.weatherapispringboot.core.logging.impl.LogBuilder;
import com.aac.learning.weather.weatherapispringboot.rest.logging.LoggingEvent;
import com.aac.learning.weather.weatherapispringboot.rest.model.ForecastResponse;
import com.aac.learning.weather.weatherapispringboot.rest.utils.ForecastResponseProcessor;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.net.URI;

@Service
public class WeatherAPIService {

    @Value("${weather-api.api.forecast.url}")
    private String weatherApiUrl;
    @Value("${weather-api.api.key}")
    private String apiKey;
    @Value("${weather-api.api.forecast.numberofdays}")
    private String numberOfDays;
    private RestTemplate weatherAPIRestTemplate;

    private static final ServiceLogger LOGGER = ServiceLoggerFactory.getServiceLogger(
            LoggerFactory.getLogger(WeatherAPIService.class));

    public WeatherAPIService(RestTemplateBuilder restTemplateBuilder){
        weatherAPIRestTemplate = restTemplateBuilder.build();
    }

    public ForecastResponse getWeatherForecast(String city){
        URI url = new UriTemplate(weatherApiUrl).expand(city, apiKey, numberOfDays);
        //System.out.println(weatherAPIRestTemplate.getForEntity(url, String.class));
        ResponseEntity<ForecastResponse> response = weatherAPIRestTemplate.getForEntity(url, ForecastResponse.class);
        ForecastResponseProcessor.processForecastResponse(response.getBody());
        System.out.println("++++++ "+response);
        LOGGER.info(new LogBuilder(LoggingEvent.EVENT_FORECAST, LoggingEvent.STEP_FORECAST_RESPONSE_RECEIVED)
                .detailMessage(LoggingEvent.MESSAGE_FORECAST_RESPONSE_RECEIVED));
        LOGGER.info(new LogBuilder(LoggingEvent.EVENT_FORECAST, LoggingEvent.STEP_FORECAST_RESPONSE_RECEIVED)
                .detailMessage(response.getBody().toString()));
        System.out.println("++++++----- "+response);
        return response.getBody();
    }
}
