package com.example.soen357foodapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecipeListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);

        recyclerView = (RecyclerView) findViewById(R.id.recipeGrid);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<RecipeModel> recipes = MainActivity._DAYS.get(0).mealsInDay.get(0).recipesInMeal;

        adapter = new RecipeListAdapter(recipes, this);

        recyclerView.setAdapter(adapter);
    }
}