package com.codecool.thecodecooltimesbackend.dao.implementation;

import com.codecool.thecodecooltimesbackend.dao.NewsDAO;
import com.codecool.thecodecooltimesbackend.model.News;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("newsMemory")
public class NewsMemory implements NewsDAO {

    @Override
    public List<News> getTopNews() {
        return null;
    }
}
