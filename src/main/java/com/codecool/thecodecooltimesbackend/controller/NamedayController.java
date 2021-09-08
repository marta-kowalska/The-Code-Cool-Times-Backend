package com.codecool.thecodecooltimesbackend.controller;

import com.codecool.thecodecooltimesbackend.model.nameday.NameDayResult;
import com.codecool.thecodecooltimesbackend.model.quote.Quote;
import com.codecool.thecodecooltimesbackend.service.NameDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nameday/v1")

public class NamedayController {

    private final NameDayService nameDayService;

    @Autowired
    public NamedayController(NameDayService nameDayService) {
        this.nameDayService = nameDayService;
    }

    @GetMapping("/today")
    public NameDayResult getTodaysNameDays() {
        return nameDayService.getTodaysNamedays();
    }
}
