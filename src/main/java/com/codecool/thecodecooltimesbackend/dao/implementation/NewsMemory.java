package com.codecool.thecodecooltimesbackend.dao.implementation;

import com.codecool.thecodecooltimesbackend.dao.NewsDAO;
import com.codecool.thecodecooltimesbackend.model.News;
import com.codecool.thecodecooltimesbackend.model.NewsResults;
import com.codecool.thecodecooltimesbackend.util.ApiRequester;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Map;


@Repository("newsMemory")
public class NewsMemory implements NewsDAO {

    private static final String BASE_URL = "https://newsapi.org/v2/";
    private static final String API_KEY = "&apiKey=803b1f20229542109d3b21b58d162064";
    private NewsResults topNewsResults;
    private LocalDateTime topNewsResultsLastUpdated;


    @Override
    public NewsResults getTopNews() {
        String URL = BASE_URL +  "top-headlines?country=us&pageSize=100" + API_KEY;
        LocalDateTime yesterdayDate =  LocalDateTime.now(ZoneId.of("UTC")).minusDays(1);
        LocalDateTime todayDate =  LocalDateTime.now(ZoneId.of("UTC"));
        System.out.println(topNewsResults);
        System.out.println(topNewsResultsLastUpdated);
        if (topNewsResultsLastUpdated!=null && (yesterdayDate.isAfter(topNewsResultsLastUpdated)) ||topNewsResults == null ) {
            topNewsResultsLastUpdated = todayDate;
            topNewsResults = ApiRequester.fetchData(URL, NewsResults.class);
        }
        System.out.println(topNewsResults);
        return topNewsResults;
    }

    @Override
    public NewsResults getTopNewsForCategory(String category) {
        LocalDateTime todayDate =  LocalDateTime.now(ZoneId.of("UTC")).withNano(0);
        LocalDateTime tomorrowDate =  LocalDateTime.from(todayDate.atZone(ZoneId.of("UTC"))).plusDays(1).withNano(0);
        String url = BASE_URL + "top-headlines?category=" +
                category +
                "&language=en" +
                "&from" + todayDate +
                "&to" + todayDate +
                "&pageSize=100" +
                API_KEY;
        NewsResults newsResults = ApiRequester.fetchData(url, NewsResults.class);
        return newsResults;
    }

    @Override
    public NewsResults getNewsOnKeyword(String keyword) {
        LocalDateTime todayDate =  LocalDateTime.now(ZoneId.of("UTC")).withNano(0);
        LocalDateTime tomorrowDate =  LocalDateTime.from(todayDate.atZone(ZoneId.of("UTC"))).plusDays(1).withNano(0);
        String url = BASE_URL + "everything?q=" +
                keyword +
                "&language=en" +
                "&from" + todayDate +
                "&to" + todayDate +
                "&pageSize=100" +
                API_KEY;
        NewsResults newsResults = ApiRequester.fetchData(url, NewsResults.class);
        return newsResults;
    }
}
