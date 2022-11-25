package com.example.soen357foodapp;

import android.content.Context;
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

public class RecipeListActivity extends AppCompatActivity {
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
        filterSpinner.setOnItemSelectedListener(new OnItemSelectedListener1());


        Spinner sortSpinner = findViewById(R.id.sortSpinner);
        ArrayAdapter<CharSequence> sortSpinnerArrayAdapter = ArrayAdapter.createFromResource(this,R.array.recipe_list_sort, android.R.layout.simple_spinner_item);
        sortSpinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sortSpinner.setAdapter(sortSpinnerArrayAdapter);
        sortSpinner.setOnItemSelectedListener(new OnItemSelectedListener2());
    }

    private class OnItemSelectedListener1 implements AdapterView.OnItemSelectedListener {
        public Context context = getApplicationContext();

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String choice = parent.getItemAtPosition(position).toString();

            recyclerView = (RecyclerView) findViewById(R.id.recipeGrid);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(context));

            ArrayList<RecipeModel> allRecipesInMeal = MainActivity._RECIPES;

            switch (choice) {
                case "Breakfast":
                    adapter = new RecipeListAdapter(RecipeModel.getRecipesByCat(allRecipesInMeal, 'B'), context);
                    recyclerView.setAdapter(adapter);
                    break;
                case "Lunch":
                    adapter = new RecipeListAdapter(RecipeModel.getRecipesByCat(allRecipesInMeal, 'L'), context);
                    recyclerView.setAdapter(adapter);
                    break;
                case "Dinner":
                    adapter = new RecipeListAdapter(RecipeModel.getRecipesByCat(allRecipesInMeal, 'D'), context);
                    recyclerView.setAdapter(adapter);
                    break;
                default:
                    adapter = new RecipeListAdapter(allRecipesInMeal, context);
                    recyclerView.setAdapter(adapter);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) { }
    }

    private class OnItemSelectedListener2 implements AdapterView.OnItemSelectedListener {
        public Context context = getApplicationContext();

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String choice = parent.getItemAtPosition(position).toString();

            recyclerView = (RecyclerView) findViewById(R.id.recipeGrid);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(context));

            ArrayList<RecipeModel> allRecipesInMeal = MainActivity._RECIPES;

            switch (choice) {
                case "Name":
                    adapter = new RecipeListAdapter(RecipeModel.sortRecipeBy(allRecipesInMeal, 'N'), context);
                    recyclerView.setAdapter(adapter);
                    break;
                case "Difficulty":
                    adapter = new RecipeListAdapter(RecipeModel.sortRecipeBy(allRecipesInMeal, 'D'), context);
                    recyclerView.setAdapter(adapter);
                    break;
                case "Time Required":
                    adapter = new RecipeListAdapter(RecipeModel.sortRecipeBy(allRecipesInMeal, 'T'), context);
                    recyclerView.setAdapter(adapter);
                    break;
                case "Rating":
                    adapter = new RecipeListAdapter(RecipeModel.sortRecipeBy(allRecipesInMeal, 'R'), context);
                    recyclerView.setAdapter(adapter);
                    break;
                default:
                    adapter = new RecipeListAdapter(allRecipesInMeal, context);
                    recyclerView.setAdapter(adapter);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) { }
    }
}