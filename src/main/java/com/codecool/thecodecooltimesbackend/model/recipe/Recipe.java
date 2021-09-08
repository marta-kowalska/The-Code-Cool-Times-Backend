package com.codecool.thecodecooltimesbackend.model.recipe;

import java.util.*;

public class Recipe {
    private String strMeal;
    private String strInstructions;
    private String strMealThumb;
    private String strSource;

    public Recipe() {
    }

    private List<String> ingredients = new ArrayList<>();
    private List<String> measures = new ArrayList<>();

    public List<String> getIngredients() {
        return ingredients;
    }

    public List<String> getMeasures() {
        return measures;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public void setMeasurements(List<String> measures) {
        this.measures = measures;
    }

    public String getStrSource() {
        return strSource;
    }

    public void setStrSource(String strSource) {
        this.strSource = strSource;
    }

    private void addIngredient(String ingredient){
        if(!ingredient.equals("") && !ingredient.equals(" ") ){
            ingredient = ingredient.substring(0,1).toUpperCase() + ingredient.substring(1).toLowerCase();
            ingredients.add(ingredient);
        }
    }

    private void addMeasure(String measure){
        if(!measure.equals("") && !measure.equals(" ") ){
            measure = measure.substring(0,1).toUpperCase() + measure.substring(1).toLowerCase();
            measures.add(measure);
        }
    }

    public String getStrMeal() {
        return strMeal;
    }

    public void setStrMeal(String strMeal) {
        this.strMeal = strMeal;
    }

    public String getStrInstructions() {
        return strInstructions;
    }

    public void setStrInstructions(String strInstructions) {
        this.strInstructions = strInstructions;
    }

    public String getStrMealThumb() {
        return strMealThumb;
    }

    public void setStrMealThumb(String strMealThumb) {
        this.strMealThumb = strMealThumb;
    }

    public void setStrIngredient1(String strIngredient1) {
        addIngredient(strIngredient1);
    }

    public void setStrIngredient2(String strIngredient2) {
        addIngredient(strIngredient2);
    }

    public void setStrIngredient3(String strIngredient3) {
        addIngredient(strIngredient3);
    }

    public void setStrIngredient4(String strIngredient4) {
        addIngredient(strIngredient4);
    }

    public void setStrIngredient5(String strIngredient5) {
        addIngredient(strIngredient5);
    }

    public void setStrIngredient6(String strIngredient6) {
        addIngredient(strIngredient6);
    }

    public void setStrIngredient7(String strIngredient7) {
        addIngredient(strIngredient7);
    }

    public void setStrIngredient8(String strIngredient8) {
        addIngredient(strIngredient8);
    }

    public void setStrIngredient9(String strIngredient9) {
        addIngredient(strIngredient9);
    }

    public void setStrIngredient10(String strIngredient10) {
        addIngredient(strIngredient10);
    }

    public void setStrMeasure1(String strMeasure1) {
        addMeasure(strMeasure1);
    }

    public void setStrMeasure2(String strMeasure2) {
        addMeasure(strMeasure2);
    }

   public void setStrMeasure3(String strMeasure3) {
       addMeasure(strMeasure3);
    }

    public void setStrMeasure4(String strMeasure4) {
        addMeasure(strMeasure4);
    }

    public void setStrMeasure5(String strMeasure5) {
        addMeasure(strMeasure5);
    }

    public void setStrMeasure6(String strMeasure6) {
        addMeasure(strMeasure6);
    }

    public void setStrMeasure7(String strMeasure7) {
        addMeasure(strMeasure7);
    }

    public void setStrMeasure8(String strMeasure8) {
        addMeasure(strMeasure8);
    }

    public void setStrMeasure9(String strMeasure9) {
        addMeasure(strMeasure9);
    }

    public void setStrMeasure10(String strMeasure10) {
        addMeasure(strMeasure10);
    }
}
