package com.codecool.thecodecooltimesbackend.service;

import com.codecool.thecodecooltimesbackend.dao.newsDAO.NewsDAO;
import com.codecool.thecodecooltimesbackend.model.news.NewsResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class NewsService {
    private final NewsDAO newsDAO;

    @Autowired
    public NewsService(@Qualifier("newsMemory") NewsDAO newsDAO) {
        this.newsDAO = newsDAO;
    }

    public NewsResults getTopNews(){
        return newsDAO.getTopNews();
    }

    public NewsResults getTopNewsForCategory(String category) {
        return newsDAO.getTopNewsForCategory(category);
    }

    public NewsResults getNewsOnKeyword(String keyword) {
        return newsDAO.getNewsOnKeyword(keyword);
    }
}
