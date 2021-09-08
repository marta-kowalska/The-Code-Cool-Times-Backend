package com.codecool.thecodecooltimesbackend.service;


import com.codecool.thecodecooltimesbackend.config.AppProperties;
import com.codecool.thecodecooltimesbackend.dao.NewsDAO;
import com.codecool.thecodecooltimesbackend.dao.quoteDAO.QuoteDAO;
import com.codecool.thecodecooltimesbackend.model.quote.Quote;
import com.codecool.thecodecooltimesbackend.util.ApiRequester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class QuoteService {

    private final QuoteDAO quoteDAO;

    @Autowired
    public QuoteService(@Qualifier("quoteMemory") QuoteDAO quoteDAO) {
        this.quoteDAO = quoteDAO;
    }

    public Quote getRandomQuote() {
        return quoteDAO.getRandomQuote();
    }
}
