package com.example.soen357foodapp;

import java.util.ArrayList;

/**
 * David-Salomon Dahan
 * Filename: RecipeModel.java
 * Creation: 2022-11-23
 */
public class RecipeModel {
    public int rid;

    public String rname, steps;

    public ArrayList<IngredientModel> ingredients;

    public int difficulty, timeRequired, rating;

    public RecipeModel(int rid, String rname, String steps, ArrayList<IngredientModel> ingredients, int difficulty, int timeRequired, int rating) {
        this.rid = rid;
        this.rname = rname;
        this.steps = steps;
        this.ingredients = ingredients;
        this.difficulty = difficulty;
        this.timeRequired = timeRequired;
        this.rating = rating;
    }

    public void addIngredient(IngredientModel ingredient) {
        this.ingredients.add(ingredient);
    }

    public void updateRating(int rating) {
        this.rating = rating;
    }
}
