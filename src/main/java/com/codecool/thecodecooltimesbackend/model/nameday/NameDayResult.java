package com.codecool.thecodecooltimesbackend.model.nameday;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class NameDayResult {

    private String todaysNameDays;

    @SuppressWarnings("unchecked")
    @JsonProperty("data")
    public void unpackNestedNameday(Map<String,Object> data) {
        Map<String,Object> namedays = (Map<String,Object>)data.get("namedays");
        this.todaysNameDays = (String) namedays.get("hu");
    }

    public String getTodaysNameDays() {
        return todaysNameDays;
    }
}
