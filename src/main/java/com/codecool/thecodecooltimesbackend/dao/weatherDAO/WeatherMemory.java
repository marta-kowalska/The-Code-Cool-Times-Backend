package com.codecool.thecodecooltimesbackend.dao.weatherDAO;

import com.codecool.thecodecooltimesbackend.model.weather.WeatherResult;
import com.codecool.thecodecooltimesbackend.util.ApiRequester;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Repository("weatherMemory")
public class WeatherMemory implements WeatherDAO {

    private static final String  API_URL = "https://api.weatherbit.io/v2.0/current?city={city}&key=135cd6338d104bbca1d1c554b96c2085";
    private WeatherResult weatherResult;
    private LocalDateTime lastFetch;

    @Override
    public WeatherResult getCurrentWeatherForCity(String city) {
        if(weatherResult == null || shouldFetchAgain()){
            String actualURL = API_URL.replace("{city}", city);
            weatherResult = ApiRequester.fetchDataGet(actualURL, WeatherResult.class);
            lastFetch = LocalDateTime.now(ZoneId.of("UTC"));
        }
        return weatherResult;
    }

    private boolean shouldFetchAgain(){
        return LocalDateTime.now(ZoneId.of("UTC")).isAfter(lastFetch.plusMinutes(10));
    }
}
