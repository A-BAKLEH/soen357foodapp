package com.example.soen357foodapp;

import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.SharedPreferences;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<UserModel> _USERS = new ArrayList<>();

    public static ArrayList<DayModel> _DAYS = new ArrayList<>();


    public void generateData() {
        _USERS.add(new UserModel("Bobby", "Brown", "pass123"));

        ArrayList<IngredientModel> omeletteIngredients = new ArrayList<>();
        omeletteIngredients.add(new IngredientModel("Egg",5));
        omeletteIngredients.add(new IngredientModel("Bell Pepper",2));
        omeletteIngredients.add(new IngredientModel("Salt",2,"tbsp"));
        omeletteIngredients.add(new IngredientModel("Black Pepper",0.5,"tbsp"));
        omeletteIngredients.add(new IngredientModel("Paprika",2.5,"tbsp"));
        omeletteIngredients.add(new IngredientModel("Garlic",2,"cloves, minced"));
        omeletteIngredients.add(new IngredientModel("Oil",1.5,"cup"));

        RecipeModel omeletteRecipe = new RecipeModel("Omelette",omeletteIngredients,0,15,5,3,"Step 1. Crack eggs over bowl\nStep 2. Beat eggs until frothy\nStep 3. Combine all ingredients in the bowl\nStep 4. Mix thoroughly\nStep 5. Pour bowl mixture into deep pan\nStep 6. Cook over medium heat for 20-25 min, until desired colour.");


        MealModel meal1 = new MealModel('b');
        meal1.addRecipeToMeal(omeletteRecipe);
        meal1.addRecipeToMeal(omeletteRecipe);
        meal1.addRecipeToMeal(omeletteRecipe);
        meal1.addRecipeToMeal(omeletteRecipe);
        meal1.addRecipeToMeal(omeletteRecipe);
        meal1.addRecipeToMeal(omeletteRecipe);
        meal1.addRecipeToMeal(omeletteRecipe);

        DayModel day1 = new DayModel(new Date());
        day1.addMealInDay(meal1);

        _DAYS.add(day1);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        generateData();
        setContentView(R.layout.activity_main);

        findViewById(R.id.box).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RecipeListActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

    }
}

