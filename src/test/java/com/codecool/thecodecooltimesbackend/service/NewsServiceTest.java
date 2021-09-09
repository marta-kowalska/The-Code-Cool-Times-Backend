package com.codecool.thecodecooltimesbackend.service;

import com.codecool.thecodecooltimesbackend.dao.newsDAO.NewsDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class NewsServiceTest {

    @Autowired
    private NewsDAO newsDAO;

    @Test
    public void contextLoads() throws Exception {
        assertThat(newsDAO).isNotNull();
    }

}