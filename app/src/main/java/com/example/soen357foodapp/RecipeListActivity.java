package com.example.soen357foodapp;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecipeListActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);


        Spinner filterSpinner = findViewById(R.id.filterSpinner);
        ArrayAdapter<CharSequence> spinnerArrayAdapter = ArrayAdapter.createFromResource(this,R.array.recipe_list_filters, android.R.layout.simple_spinner_item);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        filterSpinner.setAdapter(spinnerArrayAdapter);
        filterSpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String choice = parent.getItemAtPosition(position).toString();

        recyclerView = (RecyclerView) findViewById(R.id.recipeGrid);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<RecipeModel> allRecipesInMeal = MainActivity._RECIPES;

        adapter = new RecipeListAdapter(allRecipesInMeal, this);
        recyclerView.setAdapter(adapter);

        switch (choice) {
            case "Breakfast":
                adapter = new RecipeListAdapter(RecipeModel.getRecipesByCat(allRecipesInMeal,'B'), this);
                recyclerView.setAdapter(adapter);
                break;
            case "Lunch":
                adapter = new RecipeListAdapter(RecipeModel.getRecipesByCat(allRecipesInMeal,'L'), this);
                recyclerView.setAdapter(adapter);
                break;
            case "Dinner":
                adapter = new RecipeListAdapter(RecipeModel.getRecipesByCat(allRecipesInMeal,'D'), this);
                recyclerView.setAdapter(adapter);
                break;
            default:
                adapter = new RecipeListAdapter(allRecipesInMeal, this);
                recyclerView.setAdapter(adapter);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}