package com.example.soen357foodapp;

import java.util.ArrayList;

/**
 * David-Salomon Dahan
 * Filename: RecipeModel.java
 * Creation: 2022-11-23
 */
public class RecipeModel {
    public static int rCount; // tracks number of recipes in the system
    public int rid; // recipe id

    public String rname, steps; // recipe name and the steps to prepare it

    public ArrayList<IngredientModel> ingredients; // ingredients needed for the recipe

    public int difficulty, timeRequired, rating, servingSize; // some metrics about the recipe

    public char rcat; // (b)reakfast, (l)unch, (d)inner, used for filtering


    public RecipeModel(int rid, String rname, ArrayList<IngredientModel> ingredients, int difficulty,
                       int timeRequired, int rating, int servingSize, char rcat, String steps) {
        this.rid = rid;
        this.rname = rname;
        this.steps = steps;
        this.ingredients = ingredients;
        this.difficulty = difficulty;
        this.timeRequired = timeRequired;
        this.rating = rating;
        this.servingSize = servingSize;
    }
    public RecipeModel(String rname, ArrayList<IngredientModel> ingredients, int difficulty,
                       int timeRequired, int rating, int servingSize, char rcat, String steps) {
        this.rid = rCount;
        this.rname = rname;
        this.steps = steps;
        this.ingredients = ingredients;
        this.difficulty = difficulty;
        this.timeRequired = timeRequired;
        this.rating = rating;
        this.servingSize = servingSize;
        this.rcat = rcat;
        rCount++;
    }

    // add an ingredient to the recipe
    public void addIngredient(IngredientModel ingredient) {
        this.ingredients.add(ingredient);
    }

    // update the recipe rating
    public void updateRating(int rating) {
        this.rating = rating;
    }

    public static ArrayList<RecipeModel> getRecipesByCat(ArrayList<RecipeModel> recipes, char cat) {
        ArrayList<RecipeModel> filteredRecipes = new ArrayList<>();

        for (RecipeModel recipe : recipes)
            if (recipe.rcat == cat)
                filteredRecipes.add(recipe);

        return filteredRecipes;
    }
}
