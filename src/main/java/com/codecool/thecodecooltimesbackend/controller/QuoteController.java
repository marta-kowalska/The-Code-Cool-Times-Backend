package com.codecool.thecodecooltimesbackend.controller;

import com.codecool.thecodecooltimesbackend.config.AppProperties;
import com.codecool.thecodecooltimesbackend.model.quote.Quote;
import com.codecool.thecodecooltimesbackend.service.QuoteService;
import com.codecool.thecodecooltimesbackend.util.ApiRequester;
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

    @GetMapping("/random")
    public Quote getQuote() {
        return quoteService.getRandomQuote();
    }
}
