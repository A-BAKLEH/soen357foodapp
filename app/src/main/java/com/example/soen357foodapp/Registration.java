package com.example.soen357foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.accounts.Account;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;



import java.util.Objects;

public class Registration extends AppCompatActivity {

    protected EditText fnameSignup, lnameSignup, emailSignup, passwordSignup, passwordConfirmSignUp;
    protected Button buttonSignUp;
    private CheckBox termCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fnameSignup = findViewById(R.id.signup_fname);
        lnameSignup = findViewById(R.id.signup_lname);
        emailSignup = findViewById(R.id.signup_email);
        passwordSignup = findViewById(R.id.signup_password);
        passwordConfirmSignUp = findViewById(R.id.signup_confirm_password);
        termCheckBox = findViewById(R.id.checkBox_terms);
        buttonSignUp = findViewById(R.id.signup_button);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        Objects.requireNonNull(getSupportActionBar()).setElevation(0f);

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!passwordSignup.getText().toString().equals(passwordConfirmSignUp.getText().toString())) {
                    System.out.println(passwordSignup.getText().toString());
                    System.out.println(passwordConfirmSignUp.getText().toString());
                    Toast.makeText(getApplicationContext(), "Passwords do not match", Toast.LENGTH_SHORT).show();
                }
                else if(!termCheckBox.isChecked())
                {
                    Toast.makeText(getApplicationContext(), "You need to agree to the Terms and Privacy Policy to SignUp", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    MainActivity. _USERS.add(new UserModel(fnameSignup.getText().toString(), lnameSignup.getText().toString(), emailSignup.getText().toString(), passwordSignup.getText().toString()));
                    Toast.makeText(getApplicationContext(), "Account Created", Toast.LENGTH_SHORT).show();
                    openAccount();
                }

            }
        });

        Button btn = (Button)findViewById(R.id.login_on_signup);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Registration.this, Login.class));
            }
        });

    }

    private void openAccount()
    {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("login_result", true);
        startActivity(intent);
    }


}