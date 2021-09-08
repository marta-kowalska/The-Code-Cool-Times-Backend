package com.codecool.thecodecooltimesbackend.service;

import com.codecool.thecodecooltimesbackend.dao.NewsDAO;
import com.codecool.thecodecooltimesbackend.model.NewsResults;
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

    public NewsResults getNewsForCategory(String category){
        return null;
    }

}
