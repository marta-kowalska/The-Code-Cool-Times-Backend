package com.codecool.thecodecooltimesbackend.service;

import com.codecool.thecodecooltimesbackend.dao.RecipeDAO;
import com.codecool.thecodecooltimesbackend.model.recipe.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class RecipeService {

    private final RecipeDAO recipeDAO;

    @Autowired
    public RecipeService(@Qualifier("recipeMemory") RecipeDAO recipeDAO) {
        this.recipeDAO = recipeDAO;
    }

    public Recipe getRecipe(){
        return recipeDAO.getRandomRecipe();
    }

    // TODO should also implement getShortRecipe?
}
