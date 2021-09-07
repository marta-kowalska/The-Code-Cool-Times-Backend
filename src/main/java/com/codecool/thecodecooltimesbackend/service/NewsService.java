package com.codecool.thecodecooltimesbackend.service;

import com.codecool.thecodecooltimesbackend.dao.NewsDAO;
import com.codecool.thecodecooltimesbackend.model.News;
import com.codecool.thecodecooltimesbackend.model.NewsResults;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

@Component
public class NewsService {
    private final NewsDAO newsDAO;
    private static final ObjectMapper mapper = new ObjectMapper();

    WebClient webClient = WebClient.create();

    @Autowired
    public NewsService(@Qualifier("newsMemory") NewsDAO newsDAO) {
        this.newsDAO = newsDAO;
    }

    public NewsResults getTopNews(){
        Mono<NewsResults> response = webClient.get()
                .uri("https://newsapi.org/v2/everything?qInTitle=everything&pageSize=100&apiKey=803b1f20229542109d3b21b58d162064")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Object.class)
                .map(x -> mapper.convertValue(x, NewsResults.class));
//        System.out.println(response);
        return response.block();
    }

    public List<News> getNewsForCategory(String category){
        return null;
    }



}
