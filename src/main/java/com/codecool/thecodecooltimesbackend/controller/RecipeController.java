package com.codecool.thecodecooltimesbackend.controller;

import com.codecool.thecodecooltimesbackend.model.recipe.Recipe;
import com.codecool.thecodecooltimesbackend.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recipe/v1")
public class RecipeController {

    private final RecipeService RecipeService;

    @Autowired
    public RecipeController(RecipeService RecipeService) {
        this.RecipeService = RecipeService;
    }

    @GetMapping("/random")
    public Recipe getrandomRecipe() {
        return RecipeService.getRecipe();
    }
}
