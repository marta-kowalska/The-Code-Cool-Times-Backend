package com.codecool.thecodecooltimesbackend.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class NewsResults implements Serializable {
    private String status;
    private int totalResults;
    private List<News> articles = new ArrayList<>();

    public NewsResults(String status, int totalResults, List<News> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public NewsResults() {
    }

    @Override
    public String toString() {
        return "NewsResults{ Status: " + status + "}";
    }
}

