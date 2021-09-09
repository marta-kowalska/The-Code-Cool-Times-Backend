package com.codecool.thecodecooltimesbackend.model.news;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NewsResults {
    private List<Object> articles = new ArrayList<>();

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    private LocalDateTime lastUpdated;

    public NewsResults() {
    }


    @JsonProperty("articles")
    public void filterForTagAndLink(List<Map<String, Object>> articles) {
        List<Object> filteredArticles = new ArrayList<>();
        for (Map<String, Object> article : articles) {
            String articleString = (String) article.get("description");
            if (articleString!= null && !articleString.equals("") && !articleString.contains("<") && !articleString.contains("www.")) {
                filteredArticles.add(article);
            }
        }
        setArticles(filteredArticles);
    }


    public List<Object> getArticles() {
        return articles;
    }

    public void setArticles(List<Object> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "NewsResults{ " + articles + "}";
    }
}

