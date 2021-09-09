package com.codecool.thecodecooltimesbackend.model.weather;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class WeatherResult {

    private static final String iconURL = "https://www.weatherbit.io/static/img/icons/{icon_code}.png";

    private Number temperature;
    private String description;
    private String icon;


    @SuppressWarnings("unchecked")
    @JsonProperty("data")
    public void unpackDetails(List<Object> data) {
        Map<String,Object> details = (Map<String,Object>)data.get(0);
        this.temperature = (Number) details.get("app_temp");
        Map<String,Object> weather = (Map<String,Object>)details.get("weather");
        this.description = (String) weather.get("description");
        String iconCode = (String) weather.get("icon");
        icon = iconURL.replace("{icon_code}", iconCode);
    }

    public Number getTemperature() {
        return temperature;
    }

    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return icon;
    }
}
