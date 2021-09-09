package com.codecool.thecodecooltimesbackend.dao;


import com.codecool.thecodecooltimesbackend.model.news.NewsResults;


public interface NewsDAO {
    NewsResults getTopNews();

    NewsResults getTopNewsForCategory(String category);

    NewsResults getNewsOnKeyword(String keyword);

    Boolean shouldIFetch(String key);
}
