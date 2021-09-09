package com.codecool.thecodecooltimesbackend.service;

import com.codecool.thecodecooltimesbackend.dao.recipeDAO.RecipeDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class RecipeServiceTest {

    @Autowired
    private RecipeDAO recipeDAO;

    @Test
    public void contextLoads() throws Exception {
        assertThat(recipeDAO).isNotNull();
    }

}