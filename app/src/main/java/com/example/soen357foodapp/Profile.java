package com.example.soen357foodapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Profile extends AppCompatActivity {

    protected EditText nameInput, ageInput, weightInput, dietInput, dciInput;
    protected ImageButton infoBtn1, infoBtn2;
    protected Button updateBtn;
    protected ImageView profileImg;
    boolean inputChange = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        nameInput = findViewById(R.id.text1);
        ageInput = findViewById(R.id.txt2);
        weightInput = findViewById(R.id.txt3);
        dietInput = findViewById(R.id.txt4);
        dciInput = findViewById(R.id.txt5);
        infoBtn1 = findViewById(R.id.infoBtn1);
        infoBtn2 = findViewById(R.id.infoBtn2);
        updateBtn = findViewById(R.id.update);
        profileImg = findViewById(R.id.profile);

        //profileImage.setImageResource(R.drawable.);
        //ageInput.setText();
        //weightInput.setText();
        //dietInput.setText();
        //dciInput.setText();

        updateBtn.setEnabled(false);

        infoBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Diet Type represents the type of diet  you are following (ex. vegan, plat-based, low carbs, Mediterranean, paleo ...ect).", Toast.LENGTH_SHORT).show();
            }
        });

        infoBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "DCI is an abbreviation of Daily Calorie Intake which is the sum of calories you wish to eat in one day (note : your DCI depends on Basal Metabolic Rate).", Toast.LENGTH_SHORT).show();
            }
        });

        ageInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputChange = true;
            }
        });

        weightInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputChange = true;
            }
        });

        dietInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputChange = true;
            }
        });

        dciInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputChange = true;
            }
        });

        if (inputChange == true) {
            updateBtn.setEnabled(true);
        }

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Your data has been saved successfully!", Toast.LENGTH_SHORT).show();
                updateBtn.setEnabled(false);
                inputChange = false;
            }
        });

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
        findViewById(R.id.home).setOnClickListener(x -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        });

    }

}
