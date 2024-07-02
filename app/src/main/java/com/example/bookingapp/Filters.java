package com.example.bookingapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.slider.RangeSlider;

import java.lang.reflect.Array;

public class Filters extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_filters);

        Button[] btnDeparture = new Button[4];
        Button[] btnArrival = new Button[4];

        btnDeparture[0] = findViewById(R.id.departure_btn1);
        btnDeparture[1] = findViewById(R.id.departure_btn2);
        btnDeparture[2] = findViewById(R.id.departure_btn3);
        btnDeparture[3] = findViewById(R.id.departure_btn4);
        btnArrival[0] = findViewById(R.id.arrival_btn1);
        btnArrival[1] = findViewById(R.id.arrival_btn2);
        btnArrival[2] = findViewById(R.id.arrival_btn3);
        btnArrival[3] = findViewById(R.id.arrival_btn4);

        for (int i = 0; i < btnDeparture.length; i++) {
            final int index = i;
            btnDeparture[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Reset the selection for all buttons
                    for (Button button : btnDeparture) {
                        button.setSelected(false);
                    }
                    // Set the clicked button as selected
                    btnDeparture[index].setSelected(true);
                }
            });
        }
        for (int i = 0; i < btnArrival.length; i++) {
            final int index = i;
            btnArrival[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Reset the selection for all buttons
                    for (Button button : btnArrival) {
                        button.setSelected(false);
                    }
                    // Set the clicked button as selected
                    btnArrival[index].setSelected(true);
                }
            });
        }
    }
}