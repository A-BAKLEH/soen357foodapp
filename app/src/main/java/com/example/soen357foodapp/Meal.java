package com.example.soen357foodapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;

public class Meal extends AppCompatActivity {

    protected ImageButton backBtn, favBtn, plusBtn, checkBtn, unfavBtn;
    protected ImageView mealImage;
    protected TextView difficulty, rating, time, recipeDescription, recipeName, instruText;
    protected ExtendedFloatingActionButton plan;
    protected ListView ls;
    protected ArrayList<String> arrayList;
    protected ArrayAdapter<String> adapter;
    protected Button instructions , ingredients;
    protected RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerViewAdapter recyclerViewAdapter;
    boolean favorite = false;
    boolean inPlan = false;
    int i,j;
    int ingrImages [] = {R.drawable.beef, R.drawable.chicken, R.drawable.tomato};
    private ArrayList<String> ingrList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal);
        ingrList.add("Beef");
        ingrList.add("Chicken");
        ingrList.add("Tomato");

        backBtn = findViewById(R.id.backBtn);
        favBtn = findViewById(R.id.favBtn);
        plusBtn = findViewById(R.id.plan);
        checkBtn = findViewById(R.id.unplan);
        unfavBtn = findViewById(R.id.unfavBtn);
        mealImage = findViewById(R.id.pic);
        difficulty = findViewById(R.id.diff);
        rating = findViewById(R.id.rating);
        time = findViewById(R.id.time);
        recipeDescription = findViewById(R.id.description);
        recipeName = findViewById(R.id.name);
        ingredients = findViewById(R.id.ingr);
        instructions = findViewById(R.id.instru);
        instruText = findViewById(R.id.instruText);
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerViewAdapter = new RecyclerViewAdapter(ingrImages, ingrList);

        instruText.setVisibility(View.INVISIBLE);

        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setHasFixedSize(true);
        plusBtn.setVisibility(View.VISIBLE);
        checkBtn.setVisibility(View.INVISIBLE);
        recipeDescription.setText("Here, our chef was inspired by a risotto to create a great creamy orzo. We can find the same great ingredients of a risotto, except for the rice which was replaced by orzo. Enjoy a simple version all cooked in the oven : no needs to stir for long minutes!");
        //rating.setText();
        //difficulty.setText();
        //time.setText();
        recipeName.setText("Creamy Crevettes");
        instruText.setText("Heat oil a large skillet over medium-high heat. Season shrimp with salt and pepper and fry for 1-2 minutes on each side, until just cooked through and pink. Transfer to a bowl; set aside.\n" +
                "Melt the butter in the same skillet. Sauté garlic until fragrant (about 30 seconds). Pour in the white wine or broth; allow to reduce to half while scraping any bits off of the bottom of the pan.\n" +
                "Reduce heat to low-medium heat, add the cream and bring to a gentle simmer, while stirring occasionally. Season with salt and pepper to your taste.\n" +
                "\n" +
                "Add the parmesan cheese and allow sauce to gently simmer for a further minute or so until the cheese melts and sauce thickens.\n" +
                "Add the shrimp back into the pan, sprinkle with parsley. Taste test sauce and adjust salt and pepper, if needed.\n" +
                "Serve over pasta, rice or steamed veg.");
        mealImage.setImageResource(R.drawable.crevettes);

        favBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (j%2 == 0){
                    favBtn.setVisibility(View.INVISIBLE);
                    unfavBtn.setVisibility(View.VISIBLE);
                    favorite =true;
                }
                j++;
                Toast.makeText(getApplicationContext(), "The meal was added to your favorites!", Toast.LENGTH_SHORT).show();
            }
        });


        unfavBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (j%2 != 0){
                    unfavBtn.setVisibility(View.INVISIBLE);
                    favBtn.setVisibility(View.VISIBLE);
                    favorite = false;
                }
                j++;
                Toast.makeText(getApplicationContext(), "The meal was removed from your favorites!", Toast.LENGTH_SHORT).show();
            }
        });


        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (i%2 == 0){
                    plusBtn.setVisibility(View.INVISIBLE);
                    checkBtn.setVisibility(View.VISIBLE);
                    favorite =true;
                }
                i++;
                Toast.makeText(getApplicationContext(), "The meal was added to your plan!", Toast.LENGTH_SHORT).show();
            }
        });


        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (i%2 != 0){
                    checkBtn.setVisibility(View.INVISIBLE);
                    plusBtn.setVisibility(View.VISIBLE);
                    favorite = false;
                }
                i++;
                Toast.makeText(getApplicationContext(), "The meal was removed from your plan!", Toast.LENGTH_SHORT).show();
            }
        });

        instructions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                instructions.setBackgroundColor(Color.rgb(254,168,47));
                ingredients.setBackgroundColor(Color.rgb(35,61,77));
                recyclerView.setVisibility(View.INVISIBLE);
                instruText.setVisibility(View.VISIBLE);
                //add instructions text

            }
        });

        ingredients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ingredients.setBackgroundColor(Color.rgb(254,168,47));
                instructions.setBackgroundColor(Color.rgb(35,61,77));
                recyclerView.setVisibility(View.VISIBLE);
                instruText.setVisibility(View.INVISIBLE);
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });


    }
}
