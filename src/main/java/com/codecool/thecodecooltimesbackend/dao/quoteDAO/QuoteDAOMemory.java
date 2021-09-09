package com.codecool.thecodecooltimesbackend.dao.quoteDAO;

import com.codecool.thecodecooltimesbackend.config.AppProperties;
import com.codecool.thecodecooltimesbackend.model.quote.Quote;
import com.codecool.thecodecooltimesbackend.util.ApiRequester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("quoteMemory")
public class QuoteDAOMemory implements QuoteDAO {

    private final ApiRequester apiRequester;

    private Quote quote;
    private static final int MAX_QUOTE_LENGTH = 90;

    @Autowired
    public QuoteDAOMemory(ApiRequester apiRequester) {
        this.apiRequester = apiRequester;
    }

    public Quote getRandomQuote() {
        if (quote == null) {
            String quoteApiUrl = AppProperties.getQuoteApiUrl();
            do {
                quote = apiRequester.fetchDataGet(quoteApiUrl, Quote.class);
            } while (quote.getQuote().length() > MAX_QUOTE_LENGTH);
        }
        return quote;
    }

}
