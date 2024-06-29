package com.example.bookingapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class SignInScreen extends AppCompatActivity {

    private ImageButton backBtn;
    private Button logInBtn;
    private TextInputEditText acc, pass;
    private SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_in_screen);
        backBtn = findViewById(R.id.backbtn);
        backBtn.setOnClickListener(v -> {
            Intent intent = new Intent(SignInScreen.this, WelcomeScreen.class);
            startActivity(intent);
            finish();
        });
        logInBtn = findViewById(R.id.logIn);
        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pref = getSharedPreferences("AccountInfo", Context.MODE_PRIVATE);
                String passWord = pref.getString("Password", "");
                String email = pref.getString("Email", "");
                pass = findViewById(R.id.pass_word);
                acc = findViewById(R.id.account_email);
                if (pass.getText().toString().equals(passWord) && acc.getText().toString().equals(email)) {
                Intent intent = new Intent(SignInScreen.this, HomePage.class);
                startActivity(intent);
                finish();
                }
                else {
                    Toast.makeText(SignInScreen.this, "Wrong Email or Password", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}