package com.example.bookingapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {
    SharedPreferences.Editor editor;
    SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        setAccountInfo();
        Intent intent = new Intent(MainActivity.this, SplashScreen.class);
        startActivity(intent);
    }

    private void setAccountInfo() {
        pref = getSharedPreferences("AccountInfo", MODE_PRIVATE);
        editor = pref.edit();
        editor.putString("FirstName", "Vy");
        editor.putString("LastName", "Huynh");
        editor.putString("Email", "vy");
        editor.putString("Password", "123456");
        editor.putString("PhoneNumber", "0123456789");
        editor.putString("Image", "Default");
        editor.apply();
    }
}