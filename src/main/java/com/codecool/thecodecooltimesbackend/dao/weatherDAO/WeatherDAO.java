package com.codecool.thecodecooltimesbackend.dao.weatherDAO;

import com.codecool.thecodecooltimesbackend.model.weather.WeatherResult;

public interface WeatherDAO {
    WeatherResult getCurrentWeatherForCity(String city);
}
