package com.example.soen357foodapp;

import java.util.ArrayList;
import java.util.Date;

/**
 * David-Salomon Dahan
 * Filename: MealModel.java
 * Creation: 2022-11-23
 */
public class MealModel {
    public static int mCount; // tracks number of meals in the system
    public int mid; // meal id

    public char mcat; // (b)reakfast, (l)unch, (d)inner, used for filtering

    //public Date mdate; // date of the meal, optional based on implementation decisions to be made later

    public ArrayList<RecipeModel> recipesInMeal; // recipes in the current meal

    public MealModel(int mid, char mcat, ArrayList<RecipeModel> recipesInMeal) {
        this.mid = mid;
        this.mcat = mcat;
        this.recipesInMeal = recipesInMeal;
    }

    public MealModel(char mcat) {
        this.mid = mCount;
        this.mcat = mcat;
        this.recipesInMeal = new ArrayList<>();
    }

    public void addRecipeToMeal(RecipeModel recipe) {
        this.recipesInMeal.add(recipe);
    }
}
