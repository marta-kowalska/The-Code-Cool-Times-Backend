package com.codecool.thecodecooltimesbackend.model;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class NewsResults {
    private List<News> articles = new ArrayList<>();

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    private LocalDateTime lastUpdated;

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

