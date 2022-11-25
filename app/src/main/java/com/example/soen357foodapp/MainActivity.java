package com.example.soen357foodapp;

import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.SharedPreferences;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<UserModel> _USERS = new ArrayList<>();

    public static ArrayList<DayModel> _DAYS = new ArrayList<>();

    public static ArrayList<RecipeModel> _RECIPES = new ArrayList<>();
    protected TextView userName, time, diff, mealName;
    protected ImageView mealImg, profImg;
    protected RecyclerView recyclerView;
    protected RecyclerView.Adapter adapter;
    private ArrayList<String> ingrList = new ArrayList<>();
    RecyclerView.LayoutManager layoutManager;
    int ingrImages [] = {R.drawable.beef, R.drawable.chicken, R.drawable.tomato};
    public Context context = MainActivity.this;

    public void generateData() {
        _USERS.add(new UserModel("Bobby", "Brown", "bobby@mail.me", "pass123"));

        ArrayList<IngredientModel> omeletteIngredients = new ArrayList<>();
        omeletteIngredients.add(new IngredientModel("Egg",5));
        omeletteIngredients.add(new IngredientModel("Bell Pepper",2));
        omeletteIngredients.add(new IngredientModel("Salt",2,"tbsp"));
        omeletteIngredients.add(new IngredientModel("Black Pepper",0.5,"tbsp"));
        omeletteIngredients.add(new IngredientModel("Paprika",2.5,"tbsp"));
        omeletteIngredients.add(new IngredientModel("Garlic",2,"cloves, minced"));
        omeletteIngredients.add(new IngredientModel("Oil",1.5,"cup"));

        RecipeModel omeletteRecipe = new RecipeModel("Omelette",omeletteIngredients,0,15,5,3,'B',"Step 1. Crack eggs over bowl\nStep 2. Beat eggs until frothy\nStep 3. Combine all ingredients in the bowl\nStep 4. Mix thoroughly\nStep 5. Pour bowl mixture into deep pan\nStep 6. Cook over medium heat for 20-25 min, until desired colour.");
        RecipeModel fomeletteRecipe = new RecipeModel("FOmelette",omeletteIngredients,0,15,5,3,'B',"Step 1. Crack eggs over bowl\nStep 2. Beat eggs until frothy\nStep 3. Combine all ingredients in the bowl\nStep 4. Mix thoroughly\nStep 5. Pour bowl mixture into deep pan\nStep 6. Cook over medium heat for 20-25 min, until desired colour.");

        _RECIPES.add(omeletteRecipe);
        _RECIPES.add(omeletteRecipe);
        _RECIPES.add(omeletteRecipe);
        _RECIPES.add(omeletteRecipe);
        _RECIPES.add(omeletteRecipe);
        _RECIPES.add(omeletteRecipe);
        _RECIPES.add(omeletteRecipe);
        _RECIPES.add(fomeletteRecipe);

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

        findViewById(R.id.box).setOnClickListener(x -> {
            Intent intent = new Intent(getApplicationContext(), RecipeListActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        });

        findViewById(R.id.book).setOnClickListener(x -> {
            Intent intent = new Intent(getApplicationContext(), MealPlanActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        });
        findViewById(R.id.search).setOnClickListener(x -> {
            Intent intent = new Intent(getApplicationContext(), Magic.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        });
        ingrList.add("Beef");
        ingrList.add("Chicken");
        ingrList.add("Tomato");

        userName = findViewById(R.id.nameTxt);
        mealName = findViewById(R.id.mealName);
        time = findViewById(R.id.time1);
        diff = findViewById(R.id.diff1);
        mealImg = findViewById(R.id.mealImg);
        profImg = findViewById(R.id.profile);
        recyclerView = findViewById(R.id.recycler);
        layoutManager = new GridLayoutManager(this,2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        char choice = 'B';

        ArrayList<RecipeModel> allRecipesInMeal = MainActivity._RECIPES;

        switch (choice) {
            case 'B':
                adapter = new RecipeListAdapter(RecipeModel.getRecipesByCat(allRecipesInMeal, 'B'), context);
                recyclerView.setAdapter(adapter);
                break;
            case 'L':
                adapter = new RecipeListAdapter(RecipeModel.getRecipesByCat(allRecipesInMeal, 'L'), context);
                recyclerView.setAdapter(adapter);
                break;
            case 'D':
                adapter = new RecipeListAdapter(RecipeModel.getRecipesByCat(allRecipesInMeal, 'D'), context);
                recyclerView.setAdapter(adapter);
                break;
            default:
                adapter = new RecipeListAdapter(allRecipesInMeal, context);
                recyclerView.setAdapter(adapter);
        }

    }
}

