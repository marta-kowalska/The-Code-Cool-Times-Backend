package com.codecool.thecodecooltimesbackend.controller;

import com.codecool.thecodecooltimesbackend.service.NameDayService;
import com.codecool.thecodecooltimesbackend.service.NewsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NewsControllerTest {

    @Autowired
    private NewsService newsService;

    @Test
    public void contextLoads() throws Exception {
        assertThat(newsService).isNotNull();
    }

}