package com.codecool.thecodecooltimesbackend.dao.implementation;

import com.codecool.thecodecooltimesbackend.dao.NewsDAO;
import com.codecool.thecodecooltimesbackend.model.news.NewsResults;
import com.codecool.thecodecooltimesbackend.util.ApiRequester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;


@Repository("newsMemory")
public class NewsMemory implements NewsDAO {

    private final ApiRequester apiRequester;

    @Autowired
    public NewsMemory(ApiRequester apiRequester) {
        this.apiRequester = apiRequester;
    }
    private static final String BASE_URL = "https://newsapi.org/v2/";
    private static final String API_KEY = "&apiKey=803b1f20229542109d3b21b58d162064";
    private Map<String, NewsResults> newsContainer = new HashMap<>();

    @Override
    public NewsResults getTopNews() {
        String url = BASE_URL +  "top-headlines?country=us&pageSize=100" + API_KEY;
        LocalDateTime todayDate = LocalDateTime.now(ZoneId.of("UTC"));
        if (shouldIFetch("topNews")) {
            NewsResults topNews = apiRequester.fetchDataGet(url, NewsResults.class);
            topNews.setLastUpdated(todayDate);
            newsContainer.put("topNews", topNews);
        }
        return newsContainer.get("topNews");
    }

    @Override
    public Boolean shouldIFetch(String key) {
        LocalDateTime yesterdayDate = LocalDateTime.now(ZoneId.of("UTC")).minusHours(1);
        return !newsContainer.containsKey(key) || yesterdayDate.isAfter(newsContainer.get(key).getLastUpdated());
    }

    @Override
    public NewsResults getTopNewsForCategory(String category) {
        LocalDateTime todayDate =  LocalDateTime.now(ZoneId.of("UTC")).withNano(0);
        String url = BASE_URL + "top-headlines?category=" +
                category +
                "&language=en" +
                "&from" + todayDate +
                "&to" + todayDate +
                "&pageSize=100" +
                API_KEY;
        if (shouldIFetch(category)) {
            NewsResults topNews = apiRequester.fetchDataGet(url, NewsResults.class);
            topNews.setLastUpdated(todayDate);
            newsContainer.put(category, topNews);
        }
        return newsContainer.get(category);
    }

    @Override
    public NewsResults getNewsOnKeyword(String keyword) {
        LocalDateTime todayDate =  LocalDateTime.now(ZoneId.of("UTC")).withNano(0);
        String url = BASE_URL + "everything?q=" +
                keyword +
                "&language=en" +
                "&from" + todayDate +
                "&to" + todayDate +
                "&pageSize=100" +
                API_KEY;
        if (shouldIFetch(keyword)) {
            NewsResults topNews = apiRequester.fetchDataGet(url, NewsResults.class);
            topNews.setLastUpdated(todayDate);
            newsContainer.put(keyword, topNews);
        }
        return newsContainer.get(keyword);
    }
}
