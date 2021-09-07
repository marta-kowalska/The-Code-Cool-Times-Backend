package com.codecool.thecodecooltimesbackend.dao;

import com.codecool.thecodecooltimesbackend.model.News;

import java.util.List;

public interface NewsDAO {
    List<News> getTopNews();
}
