package com.codecool.thecodecooltimesbackend.controller;

import com.codecool.thecodecooltimesbackend.model.news.NewsResults;
import com.codecool.thecodecooltimesbackend.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

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
        return newsService.getTopNews();
    }

    @GetMapping("/category={category}")
    public NewsResults getTopNewsForCategory(@PathVariable("category") String category) {
        return newsService.getTopNewsForCategory(category);
    }

    @GetMapping("/keyword={keyword}")
    public NewsResults getNewsOnKeyword(@PathVariable("keyword") String keyword) {
        return newsService.getNewsOnKeyword(keyword);
    }

}