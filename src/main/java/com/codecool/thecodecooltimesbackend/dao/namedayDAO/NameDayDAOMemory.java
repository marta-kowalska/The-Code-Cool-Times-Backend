package com.codecool.thecodecooltimesbackend.dao.namedayDAO;

import com.codecool.thecodecooltimesbackend.model.nameday.NameDayResult;
import com.codecool.thecodecooltimesbackend.model.quote.Quote;
import com.codecool.thecodecooltimesbackend.util.ApiRequester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Repository("nameDayMemory")
public class NameDayDAOMemory implements NameDayDAO {

    private final ApiRequester apiRequester;

    private NameDayResult nameDayResult;
    private LocalDateTime lastFetch;

    @Autowired
    public NameDayDAOMemory(ApiRequester apiRequester) {
        this.apiRequester = apiRequester;
    }

    private static final String NAMEDAY_API = "https://nameday.abalin.net/today";

    @Override
    public NameDayResult getTodaysNameDay() {
        if (nameDayResult == null || shouldFetchAgain()) {
            nameDayResult = apiRequester.fetchDataPost(NAMEDAY_API, NameDayResult.class);
            lastFetch = LocalDateTime.now(ZoneId.of("UTC"));
        }
        return nameDayResult;
    }

    private boolean shouldFetchAgain(){
        return LocalDateTime.now(ZoneId.of("UTC")).isAfter(lastFetch.plusHours(1));
    }
}
