package com.codecool.thecodecooltimesbackend.dao.quoteDAO;

import com.codecool.thecodecooltimesbackend.config.AppProperties;
import com.codecool.thecodecooltimesbackend.model.quote.Quote;
import com.codecool.thecodecooltimesbackend.model.recipe.RecipeResults;
import com.codecool.thecodecooltimesbackend.util.ApiRequester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Repository("quoteMemory")
public class QuoteDAOMemory implements QuoteDAO {

    private final ApiRequester apiRequester;

    private Quote quote;
    private LocalDateTime lastFetch;
    private static final int MAX_QUOTE_LENGTH = 90;
    private static final String quoteApiUrl;

    static {
        quoteApiUrl = AppProperties.getQuoteApiUrl();
    }

    @Autowired
    public QuoteDAOMemory(ApiRequester apiRequester) {
        this.apiRequester = apiRequester;
    }

    public Quote getRandomQuote() {
        if (quote == null || shouldFetchAgain()) {
            quote = fetchQuote();
            lastFetch = LocalDateTime.now(ZoneId.of("UTC"));
        }
        return quote;
    }

    private Quote fetchQuote(){
        Quote newQuote;
        do {
            newQuote = apiRequester.fetchDataGet(quoteApiUrl, Quote.class);
        } while (newQuote.getQuote().length() > MAX_QUOTE_LENGTH);

        return newQuote;
    }

    private boolean shouldFetchAgain(){
        return LocalDateTime.now(ZoneId.of("UTC")).isAfter(lastFetch.plusMinutes(1));
    }

}
