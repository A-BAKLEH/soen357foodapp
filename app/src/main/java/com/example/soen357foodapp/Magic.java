package com.example.soen357foodapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;


import java.util.ArrayList;

public class Magic extends AppCompatActivity {

    protected EditText userInput;
    protected Button add, magic;
    protected ImageButton backBtn;
    protected ListView ls;
    protected ArrayList<String> arrayList;
    protected ArrayAdapter<String> adapter;
    int ingrImages [] = {R.drawable.beef, R.drawable.chicken, R.drawable.tomato};
    String ingrList [] = {"Beef", "Chicken", "Tomato" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magic);

        userInput = findViewById(R.id.input);
        add = findViewById(R.id.btn1);
        magic = findViewById(R.id.btn2);
        ls = findViewById(R.id.list);
        backBtn = findViewById(R.id.returnBtn);

        arrayList = new ArrayList<>();


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.add(userInput.getText().toString());
                //ingrList.add(userInput.getText().toString());
                userInput.getText().clear();
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(), Magic.class);
                //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                //startActivity(intent);
            }
        });

        magic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //go to food recipe for you page with specific filter (ingrList)
                //Intent intent = new Intent(getApplicationContext(), Magic.class);
                //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                //intent.putExtra("login_result", true);
                //startActivity(intent);
            }
        });



    }

}
