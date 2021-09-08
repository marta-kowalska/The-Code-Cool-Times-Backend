package com.codecool.thecodecooltimesbackend.controller;

import com.codecool.thecodecooltimesbackend.service.NewsService;
import com.codecool.thecodecooltimesbackend.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quote/v1")

public class QuoteController {

    private final QuoteService quoteService;

    @Autowired
    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping("/")
    public String getQuote() {
        return "Hello QuoteController!";
    }

}
