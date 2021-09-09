package com.codecool.thecodecooltimesbackend.service;

import com.codecool.thecodecooltimesbackend.dao.weatherDAO.WeatherDAO;
import com.codecool.thecodecooltimesbackend.model.weather.WeatherResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class WeatherService {
    private final WeatherDAO weatherDAO;

    @Autowired
    public WeatherService(@Qualifier("weatherMemory") WeatherDAO weatherDAO) {
        this.weatherDAO = weatherDAO;
    }

    public WeatherResult getCurrentWeatherForCity(String city){
        return weatherDAO.getCurrentWeatherForCity(city);
    }
}
