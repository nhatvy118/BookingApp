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
        initFilter();
        Intent intent = new Intent(MainActivity.this,SplashScreen.class);
        startActivity(intent);
    }


    private void initFilter() {
        pref = getSharedPreferences("FilterPrefs", MODE_PRIVATE);
        editor = pref.edit();
        editor.putBoolean("Filter", false);

        for (int i = 0; i < 4; i++) {
           editor.putBoolean("btnDeparture" + i, false);
           editor.putBoolean("btnArrival" + i, false);
        }
        for (int i = 0; i < 5; i++) {
            editor.putBoolean("checkbox" + i, false);
        }
        editor.putInt("minPrice", 0);
        editor.putInt("maxPrice", 300);
        editor.apply();
    }

    private void setAccountInfo() {
        pref = getSharedPreferences("AccountInfo", MODE_PRIVATE);
        editor = pref.edit();
        editor.putString("FirstName", "Vy");
        editor.putString("LastName", "Huynh");
        editor.putString("Email", "vy@gmail.com");
        editor.putString("Password", "123");
        editor.putString("PhoneNumber", "+84348925571");
        editor.putString("Image", "Default");
        editor.apply();
    }


}