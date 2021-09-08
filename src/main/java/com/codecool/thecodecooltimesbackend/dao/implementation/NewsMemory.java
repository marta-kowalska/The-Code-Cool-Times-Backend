package com.codecool.thecodecooltimesbackend.dao.implementation;

import com.codecool.thecodecooltimesbackend.dao.NewsDAO;
import com.codecool.thecodecooltimesbackend.model.news.NewsResults;
import com.codecool.thecodecooltimesbackend.util.ApiRequester;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;


@Repository("newsMemory")
public class NewsMemory implements NewsDAO {

    private static final String BASE_URL = "https://newsapi.org/v2/";
    private static final String API_KEY = "&apiKey=803b1f20229542109d3b21b58d162064";
    private Map<String, NewsResults> newsContainer = new HashMap<>();

    @Override
    public NewsResults getTopNews() {
        String url = BASE_URL +  "top-headlines?country=us&pageSize=100" + API_KEY;
        LocalDateTime yesterdayDate = LocalDateTime.now(ZoneId.of("UTC")).minusDays(1);
        LocalDateTime todayDate = LocalDateTime.now(ZoneId.of("UTC"));
        if (!newsContainer.containsKey("topNews") || yesterdayDate.isAfter(newsContainer.get("topNews").getLastUpdated())) {
            NewsResults topNews = ApiRequester.fetchDataGet(url, NewsResults.class);
            topNews.setLastUpdated(todayDate);
            newsContainer.put("topNews", topNews);
        }
        return newsContainer.get("topNews");
    }

    @Override
    public NewsResults getTopNewsForCategory(String category) {
        LocalDateTime todayDate =  LocalDateTime.now(ZoneId.of("UTC")).withNano(0);
        LocalDateTime yesterdayDate = LocalDateTime.now(ZoneId.of("UTC")).minusDays(1);

        String url = BASE_URL + "top-headlines?category=" +
                category +
                "&language=en" +
                "&from" + todayDate +
                "&to" + todayDate +
                "&pageSize=100" +
                API_KEY;
        if (!newsContainer.containsKey(category) || yesterdayDate.isAfter(newsContainer.get(category).getLastUpdated())) {
            NewsResults topNewsForCategory = ApiRequester.fetchDataGet(url, NewsResults.class);
            topNewsForCategory.setLastUpdated(todayDate);
            newsContainer.put(category, topNewsForCategory);
        }
        return newsContainer.get(category);
    }

    @Override
    public NewsResults getNewsOnKeyword(String keyword) {
        LocalDateTime todayDate =  LocalDateTime.now(ZoneId.of("UTC")).withNano(0);
        LocalDateTime yesterdayDate = LocalDateTime.now(ZoneId.of("UTC")).minusDays(1);
        String url = BASE_URL + "everything?q=" +
                keyword +
                "&language=en" +
                "&from" + todayDate +
                "&to" + todayDate +
                "&pageSize=100" +
                API_KEY;
        if (!newsContainer.containsKey(keyword) || yesterdayDate.isAfter(newsContainer.get(keyword).getLastUpdated())) {
            NewsResults topNewsForKeyword = ApiRequester.fetchDataGet(url, NewsResults.class);
            topNewsForKeyword.setLastUpdated(todayDate);
            newsContainer.put(keyword, topNewsForKeyword);
        }
        return newsContainer.get(keyword);
    }
}
