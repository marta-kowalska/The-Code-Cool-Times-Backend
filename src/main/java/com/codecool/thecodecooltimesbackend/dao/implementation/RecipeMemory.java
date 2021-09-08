package com.codecool.thecodecooltimesbackend.dao.implementation;

import com.codecool.thecodecooltimesbackend.dao.RecipeDAO;
import com.codecool.thecodecooltimesbackend.model.recipe.Recipe;
import com.codecool.thecodecooltimesbackend.model.recipe.RecipeResults;
import com.codecool.thecodecooltimesbackend.util.ApiRequester;
import org.springframework.stereotype.Repository;


@Repository("recipeMemory")
public class RecipeMemory implements RecipeDAO {

    private static final String API_URL = "https://www.themealdb.com/api/json/v1/1/random.php";

    private RecipeResults recipeResults;

    @Override
    public Recipe getRandomRecipe() {
        if(recipeResults == null){
            recipeResults = fetchRecipe();
        }
        return recipeResults.getFirstRecipe();
    }

    private RecipeResults fetchRecipe(){
        return ApiRequester.fetchData(API_URL, RecipeResults.class);
    }




}
