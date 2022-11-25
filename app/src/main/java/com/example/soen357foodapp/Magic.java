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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;


import java.util.ArrayList;

public class Magic extends AppCompatActivity {

    protected EditText userInput;
    protected Button add, magic;
    protected ImageButton backBtn;
    protected RecyclerView recyclerView;
    private ArrayList<String> ingrList = new ArrayList<>();
    RecyclerView.LayoutManager layoutManager;
    RecyclerViewAdapter recyclerViewAdapter;
    int ingrImages [] = {R.drawable.beef, R.drawable.chicken, R.drawable.tomato};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magic);

        userInput = findViewById(R.id.input);
        add = findViewById(R.id.btn1);
        magic = findViewById(R.id.btn2);
        backBtn = findViewById(R.id.returnBtn);
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new GridLayoutManager(this,2);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ingrList.add(userInput.getText().toString());
                recyclerView.setLayoutManager(layoutManager);
                recyclerViewAdapter = new RecyclerViewAdapter(ingrImages, ingrList);

                recyclerView.setAdapter(recyclerViewAdapter);
                recyclerView.setHasFixedSize(true);
                userInput.getText().clear();
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
