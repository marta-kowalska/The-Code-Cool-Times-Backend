package com.codecool.thecodecooltimesbackend.controller;

import com.codecool.thecodecooltimesbackend.service.QuoteService;
import com.codecool.thecodecooltimesbackend.service.RecipeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RecipeControllerTest {

    @Autowired
    private RecipeService recipeService;

    @Test
    public void contextLoads() throws Exception {
        assertThat(recipeService).isNotNull();
    }

}