package com.codecool.thecodecooltimesbackend.model;


import java.util.ArrayList;
import java.util.List;

public class NewsResults {
    private List<News> articles = new ArrayList<>();

    public NewsResults() {
    }

    public List<News> getArticles() {
        return articles;
    }

    public void setArticles(List<News> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "NewsResults{ " + articles + "}";
    }
}

