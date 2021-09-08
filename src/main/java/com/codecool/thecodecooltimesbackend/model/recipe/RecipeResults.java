package com.codecool.thecodecooltimesbackend.model.recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeResults {

        private List<Recipe> meals = new ArrayList<>();

        public RecipeResults() {
        }

        public List<Recipe> getMeals() {
            return meals;
        }

        public void setMeals(List<Recipe> meals) {
            this.meals = meals;
        }

        public Recipe getFirstRecipe(){
            return meals.get(0);
        }
}
