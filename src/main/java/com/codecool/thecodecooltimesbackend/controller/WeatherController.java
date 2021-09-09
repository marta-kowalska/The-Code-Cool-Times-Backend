package com.codecool.thecodecooltimesbackend.controller;


import com.codecool.thecodecooltimesbackend.model.weather.WeatherResult;
import com.codecool.thecodecooltimesbackend.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather/v1")
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/city={city}")
    public WeatherResult getCurrentWeatherForCity(@PathVariable("city") String city) {
        return weatherService.getCurrentWeatherForCity(city);
    }
}
