package com.example.soen357foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;


public class Login extends AppCompatActivity {

    protected EditText emailLogin, passwordLogin;
    protected Button buttonLogin;
    protected TextView noAccountText, sign_up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailLogin = findViewById(R.id.login_email);
        passwordLogin = findViewById(R.id.login_password);
        buttonLogin = findViewById(R.id.login_button);
        noAccountText = findViewById(R.id.no_account_text);
        //sign_up = findViewById(R.id.signup_on_login);

        String adminemail = "admin@admin.com";
        String adminpassword = "admin";
        Objects.requireNonNull(getSupportActionBar()).setElevation(0f);
        getSupportActionBar().setTitle(null);


        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(emailLogin.getText().toString().equals(adminemail) && passwordLogin.getText().toString().equals(adminpassword)){
                    openMain();

                }
                else if(emailLogin.getText().length() == 0 && passwordLogin.getText().length() == 0){
                    Toast.makeText(getApplicationContext(), "Please Enter Your Credentials", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
                }

            }
        });

        Button btn2 = (Button)findViewById(R.id.signup_on_login);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), Registration.class);
                startActivity(intent);
                //startActivity(new Intent(Login.this, Registration.class));
            }
        });
/*
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMain();
            }
        });
*/
    }

    public void openMain()
    {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("login_result", true);
        startActivity(intent);
    }

}