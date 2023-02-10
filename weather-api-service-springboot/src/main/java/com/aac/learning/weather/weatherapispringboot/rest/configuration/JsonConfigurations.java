package com.aac.learning.weather.weatherapispringboot.rest.configuration;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class JsonConfigurations {
  @Bean
  public Jackson2ObjectMapperBuilder objectMapperBuilder() {
    Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
    builder.serializationInclusion(JsonInclude.Include.NON_NULL);
    builder.serializationInclusion(JsonInclude.Include.NON_EMPTY);
    builder.failOnUnknownProperties(false);
    return builder;
  }
}
