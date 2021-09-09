package com.codecool.thecodecooltimesbackend.dao.implementation;

import com.codecool.thecodecooltimesbackend.dao.RecipeDAO;
import com.codecool.thecodecooltimesbackend.model.recipe.Recipe;
import com.codecool.thecodecooltimesbackend.model.recipe.RecipeResults;
import com.codecool.thecodecooltimesbackend.util.ApiRequester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.ZoneId;



@Repository("recipeMemory")
public class RecipeMemory implements RecipeDAO {

    private final ApiRequester apiRequester;

    private static final String API_URL = "https://www.themealdb.com/api/json/v1/1/random.php";

    private RecipeResults recipeResults;
    private LocalDateTime lastFetch;

    @Autowired
    public RecipeMemory(ApiRequester apiRequester) {
        this.apiRequester = apiRequester;
    }

    @Override
    public Recipe getRandomRecipe() {
        if(recipeResults == null || shouldFetchAgain()) {
            recipeResults = fetchRecipe();
            lastFetch = LocalDateTime.now(ZoneId.of("UTC"));
        }
        return recipeResults.getFirstRecipe();
    }

    private RecipeResults fetchRecipe(){
        return apiRequester.fetchDataGet(API_URL, RecipeResults.class);
    }

    private boolean shouldFetchAgain(){
        return LocalDateTime.now(ZoneId.of("UTC")).isAfter(lastFetch.plusHours(1));
    }




}
