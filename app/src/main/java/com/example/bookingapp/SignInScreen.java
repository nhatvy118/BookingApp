package com.example.bookingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignInScreen extends AppCompatActivity {

    ImageButton backBtn;
    Button logInBtn;
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
                Intent intent = new Intent(SignInScreen.this, HomePage.class);
                startActivity(intent);
                finish();
            }
        });

    }
}