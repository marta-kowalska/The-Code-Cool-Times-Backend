package com.codecool.thecodecooltimesbackend.dao.quoteDAO;

import com.codecool.thecodecooltimesbackend.config.AppProperties;
import com.codecool.thecodecooltimesbackend.model.quote.Quote;
import com.codecool.thecodecooltimesbackend.util.ApiRequester;
import org.springframework.stereotype.Repository;

@Repository("quoteMemory")
public class QuoteDAOMemory implements QuoteDAO {

    private Quote quote;
    private static final int MAX_QUOTE_LENGTH = 90;

    public Quote getRandomQuote() {
        if (quote == null) {
            String quoteApiUrl = AppProperties.getQuoteApiUrl();
            int count = 0;
            do {
                quote = ApiRequester.fetchDataGet(quoteApiUrl, Quote.class);
                System.out.println(++count);
            } while (quote.getQuote().length() > MAX_QUOTE_LENGTH);
        }
        return quote;
    }

}
