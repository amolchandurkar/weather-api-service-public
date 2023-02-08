package com.aac.learning.weather.weatherapispringboot.rest.controller;

import com.aac.learning.weather.weatherapispringboot.rest.model.ForecastResponse;
import com.aac.learning.weather.weatherapispringboot.rest.services.WeatherAPIService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class WeatherAPIForcastControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    private ObjectMapper objectMapper;
    @MockBean
    private WeatherAPIService weatherAPIService;
    private MockMvc mockMvc;

    @BeforeEach
    void init(){
        mockMvc =
                MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        setupForecast();
    }

    @Test
    void getWeatherForecastWithValidEndpointTest() throws Exception {
        String result =
                mockMvc.perform(MockMvcRequestBuilders.get("/api/weather-forecast/Pune")
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON))
                        .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                        .andReturn()
                        .getResponse()
                        .getContentAsString();
        System.out.println("result:  "+result);
    }
    private void setupForecast(){
        when(weatherAPIService.getWeatherForecast(any())).thenReturn(
                new ForecastResponse(200,"",3,null,null));
    }
}