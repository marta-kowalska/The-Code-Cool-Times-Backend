package com.codecool.thecodecooltimesbackend.dao.implementation;

import com.codecool.thecodecooltimesbackend.dao.RecipeDAO;
import com.codecool.thecodecooltimesbackend.model.recipe.Recipe;
import com.codecool.thecodecooltimesbackend.model.recipe.RecipeResults;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Repository("recipeMemory")
public class RecipeMemory implements RecipeDAO {

    WebClient webClient = WebClient.create();

    @Override
    public Recipe getRandomRecipe() {
        return fetchRecipe().getFirstRecipe();
    }

    private RecipeResults fetchRecipe(){
        Mono<RecipeResults> response = webClient.get()
            .uri("https://www.themealdb.com/api/json/v1/1/random.php")
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(RecipeResults.class);
        return response.block();
    }

    // TODO should also implement getShortRecipe?



}
