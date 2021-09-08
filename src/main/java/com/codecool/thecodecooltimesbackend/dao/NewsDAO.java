package com.codecool.thecodecooltimesbackend.dao;


import com.codecool.thecodecooltimesbackend.model.news.NewsResults;


public interface NewsDAO {
    NewsResults getTopNews();
}
