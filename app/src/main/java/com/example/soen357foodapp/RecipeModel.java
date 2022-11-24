package com.example.soen357foodapp;

import java.util.ArrayList;

/**
 * David-Salomon Dahan
 * Filename: RecipeModel.java
 * Creation: 2022-11-23
 */
public class RecipeModel {
    public int rid; // recipe id

    public String rname, steps; // recipe name and the steps to prepare it

    public ArrayList<IngredientModel> ingredients; // ingredients needed for the recipe

    public int difficulty, timeRequired, rating, servingSize; // some metrics about the recipe

    public RecipeModel(int rid, String rname, String steps, ArrayList<IngredientModel> ingredients, int difficulty,
                       int timeRequired, int rating, int servingSize) {
        this.rid = rid;
        this.rname = rname;
        this.steps = steps;
        this.ingredients = ingredients;
        this.difficulty = difficulty;
        this.timeRequired = timeRequired;
        this.rating = rating;
        this.servingSize = servingSize;
    }

    // add an ingredient to the recipe
    public void addIngredient(IngredientModel ingredient) {
        this.ingredients.add(ingredient);
    }

    // update the recipe rating
    public void updateRating(int rating) {
        this.rating = rating;
    }
}
