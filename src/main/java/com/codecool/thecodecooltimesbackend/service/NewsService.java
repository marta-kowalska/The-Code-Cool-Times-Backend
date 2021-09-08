package com.codecool.thecodecooltimesbackend.service;

import com.codecool.thecodecooltimesbackend.dao.NewsDAO;
import com.codecool.thecodecooltimesbackend.model.News;
import com.codecool.thecodecooltimesbackend.model.NewsResults;
import com.codecool.thecodecooltimesbackend.util.ApiRequester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class NewsService {
    private final NewsDAO newsDAO;
    private static final String API_URL = "https://newsapi.org/v2/everything?qInTitle=everything&pageSize=100&apiKey=803b1f20229542109d3b21b58d162064";

    @Autowired
    public NewsService(@Qualifier("newsMemory") NewsDAO newsDAO) {
        this.newsDAO = newsDAO;
    }

    public NewsResults getTopNews(){
        return ApiRequester.fetchData(API_URL, NewsResults.class);
    }

    public List<News> getNewsForCategory(String category){
        return null;
    }

}
