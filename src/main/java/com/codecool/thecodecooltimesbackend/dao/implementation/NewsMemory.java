package com.codecool.thecodecooltimesbackend.dao.implementation;

import com.codecool.thecodecooltimesbackend.dao.NewsDAO;
import com.codecool.thecodecooltimesbackend.model.NewsResults;
import com.codecool.thecodecooltimesbackend.util.ApiRequester;
import org.springframework.stereotype.Repository;


@Repository("newsMemory")
public class NewsMemory implements NewsDAO {


    private static final String API_URL = "https://newsapi.org/v2/everything?qInTitle=everything&pageSize=100&apiKey=803b1f20229542109d3b21b58d162064";

    @Override
    public NewsResults getTopNews() {
        return ApiRequester.fetchData(API_URL, NewsResults.class);

    }
}
