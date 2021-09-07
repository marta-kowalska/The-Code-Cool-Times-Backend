package com.codecool.thecodecooltimesbackend.controller;

import com.codecool.thecodecooltimesbackend.model.News;
import com.codecool.thecodecooltimesbackend.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news/v1")

public class NewsController {

    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/top-news")
    public List<News> getTopNews() {
        return newsService.getTopNews();
    }

    @GetMapping("/today/{category}")
    public List<News> getNewsForCategory(@PathVariable("category") String category) {
        return newsService.getNewsForCategory(category);
    }
}