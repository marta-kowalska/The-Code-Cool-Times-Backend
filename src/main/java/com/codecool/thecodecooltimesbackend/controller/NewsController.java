package com.codecool.thecodecooltimesbackend.controller;

import com.codecool.thecodecooltimesbackend.model.News;
import com.codecool.thecodecooltimesbackend.model.NewsResults;
import com.codecool.thecodecooltimesbackend.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/news/v1")

public class NewsController {

    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/")
    public String getMainPage() {
        return "Hello Code Cool Times!";
    }

    @GetMapping("/top-news")
    public NewsResults getTopNews(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "http://localhost:3000");
        // TODO create WebFilter for all routes if needed
        return newsService.getTopNews();
    }

    @GetMapping("/today/{category}")
    public List<News> getNewsForCategory(@PathVariable("category") String category) {
        return newsService.getNewsForCategory(category);
    }
}