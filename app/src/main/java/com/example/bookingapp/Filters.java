package com.example.bookingapp;

import static com.example.bookingapp.Adapter.DateAdapter.registerOnClickDateListener;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class Filters extends AppCompatActivity implements OnRangeChangeListener{

    private String departure = null;
    private String arrival = null;
    private EditText minText;
    private EditText maxText;
    // Initialize buttons
    Button[] btnDeparture = new Button[4];
    Button[] btnArrival = new Button[4];
    CheckBox[] checkbox = new CheckBox[5];
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private RangeSliderView slider;
    private ImageButton backbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RangeSliderView.registerOnRangeChangeListener(this);
        setContentView(R.layout.activity_filters);
        slider = findViewById(R.id.rangeSlider);
        minText = findViewById(R.id.minPrice);
        maxText = findViewById(R.id.maxPrice);
        btnDeparture[0] = findViewById(R.id.departure_btn1);
        btnDeparture[1] = findViewById(R.id.departure_btn2);
        btnDeparture[2] = findViewById(R.id.departure_btn3);
        btnDeparture[3] = findViewById(R.id.departure_btn4);
        btnArrival[0] = findViewById(R.id.arrival_btn1);
        btnArrival[1] = findViewById(R.id.arrival_btn2);
        btnArrival[2] = findViewById(R.id.arrival_btn3);
        btnArrival[3] = findViewById(R.id.arrival_btn4);
        checkbox[0] = findViewById(R.id.arrival_time_checkbox);
        checkbox[1] = findViewById(R.id.departure_time_checkbox);
        checkbox[2] = findViewById(R.id.price_checkbox);
        checkbox[3] = findViewById(R.id.lowest_fare_checkbox);
        checkbox[4] = findViewById(R.id.duration_checkbox);
        backbtn = findViewById(R.id.back_button);
        restoreFilterState();
        minText.setText("$" + slider.getCurrentMin());
        maxText.setText("$" + slider.getCurrentMax());
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        minText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tmpMin = minText.getText().toString();
                if (tmpMin.startsWith("$")){
                    tmpMin = tmpMin.substring(1);
                }
                if (Integer.parseInt(tmpMin) > slider.getCurrentMax()){
                    Toast.makeText(Filters.this, "Min price must be less than max price", Toast.LENGTH_SHORT).show();
                }else{
                    slider.setStartValue(Integer.parseInt(tmpMin));
                    minText.setText("$" + slider.getCurrentMin());
                }

            }
        });
        maxText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tmpMax = maxText.getText().toString();
                if (tmpMax.startsWith("$")){
                    tmpMax = tmpMax.substring(1);
                }
                if (Integer.parseInt(tmpMax) < slider.getCurrentMin()){
                    Toast.makeText(Filters.this, "Max price must be greater than min price", Toast.LENGTH_SHORT).show();
                }else{
                    slider.setEndValue(Integer.parseInt(tmpMax));
                    maxText.setText("$" + slider.getCurrentMax());
                }

            }
        });

        for (int i = 0; i < btnDeparture.length; i++) {
            final int index = i;
            btnDeparture[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for (Button button : btnDeparture) {
                        button.setSelected(false);
                    }
                    btnDeparture[index].setSelected(true);
                    departure = btnDeparture[index].getText().toString();
                }
            });
        }
        for (int i = 0; i < btnArrival.length; i++) {
            final int index = i;
            btnArrival[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for (Button button : btnArrival) {
                        button.setSelected(false);
                    }
                    btnArrival[index].setSelected(true);
                    arrival = btnArrival[index].getText().toString();
                }
            });
        }







        // Done button logic
        Button doneButton = findViewById(R.id.done_btn);
        doneButton.setOnClickListener(v -> {
            Intent resultIntent = new Intent();
            if (checkbox[1].isChecked()) {
                resultIntent.putExtra("option1", "departure");
            }else{
                resultIntent.putExtra("option1", "null");
            }
            if (checkbox[2].isChecked()) {
                resultIntent.putExtra("option2", "price");
            }else{
                resultIntent.putExtra("option2", "null");
            }
            if (checkbox[1].isChecked()) {
                String startTime = departure.substring(0, departure.indexOf('-')).trim();
                if (startTime.startsWith("0") && startTime.length() > 1) {
                    startTime = startTime.substring(1);
                }
                if (!startTime.contains(":")) {
                    startTime = startTime.substring(0, startTime.length() - 2) + ":00 " + startTime.substring(startTime.length() - 2);
                }

                String endTime = departure.substring(departure.indexOf('-') + 2).trim();
                if (endTime.startsWith("0") && endTime.length() > 1) {
                    endTime = endTime.substring(1);
                }
                if (!endTime.contains(":")) {
                    endTime = endTime.substring(0, endTime.length() - 2) + ":00 " + endTime.substring(endTime.length() - 2);
                }

                resultIntent.putExtra("startTime", startTime);
                resultIntent.putExtra("endTime", endTime);
            }else{
                resultIntent.putExtra("startTime", "null");
                resultIntent.putExtra("endTime", "null");
            }
            if (checkbox[2].isChecked()){
                resultIntent.putExtra("minPrice", slider.getCurrentMin());
                resultIntent.putExtra("maxPrice", slider.getCurrentMax());
            }else{
                resultIntent.putExtra("minPrice", "null");
                resultIntent.putExtra("maxPrice", "null");
            }
            if (checkbox[2].isChecked() || checkbox[1].isChecked()) {
                resultIntent.putExtra("IsFilters", "IsFilter");
            }else{
                resultIntent.putExtra("IsFilters", "null");
            }
            saveFilterState();
            setResult(RESULT_OK, resultIntent);
            finish();

        });

        Button resetButton = findViewById(R.id.reset_btn);
        resetButton.setOnClickListener(v -> resetFilters());
    }



    @Override
    public void onRangeChange(int min, int max) {
        minText.setText("$" + min);
        maxText.setText("$" + max);
    }
    private void resetFilters() {
        departure = null;
        arrival = null;

        for (Button button : btnDeparture) {
            button.setSelected(false);
        }
        for (Button button : btnArrival) {
            button.setSelected(false);
        }
        for (CheckBox box : checkbox) {
            box.setChecked(false);
        }

        slider.setStartValue(0);
        slider.setEndValue(300);

        minText.setText("$0");
        maxText.setText("$300");

        pref = getSharedPreferences("FilterPrefs", Context.MODE_PRIVATE);
        pref.edit().clear().apply();
    }
    private void restoreFilterState() {
        pref = getSharedPreferences("FilterPrefs", Context.MODE_PRIVATE);

        for (int i = 0; i < btnDeparture.length; i++) {
            btnDeparture[i].setSelected(pref.getBoolean("btnDeparture" + i, false));
        }

        for (int i = 0; i < btnArrival.length; i++) {
            btnArrival[i].setSelected(pref.getBoolean("btnArrival" + i, false));
        }

        for (int i = 0; i < checkbox.length; i++) {
            checkbox[i].setChecked(pref.getBoolean("checkbox" + i, false));
        }

        int minPrice = pref.getInt("minPrice", 0);
        int maxPrice = pref.getInt("maxPrice", 300);
        Log.d("minPrice", String.valueOf(minPrice));
        Log.d("maxPrice", String.valueOf(maxPrice));
        slider.setEndValue(maxPrice);
        slider.setStartValue(minPrice);


        minText.setText("$" + minPrice);
        maxText.setText("$" + maxPrice);
    }
    private void saveFilterState() {
        pref = getSharedPreferences("FilterPrefs", MODE_PRIVATE);
        editor = pref.edit();


        for (int i = 0; i < btnDeparture.length; i++) {
            editor.putBoolean("btnDeparture" + i, btnDeparture[i].isSelected());
        }

        for (int i = 0; i < btnArrival.length; i++) {
            editor.putBoolean("btnArrival" + i, btnArrival[i].isSelected());
        }

        for (int i = 0; i < checkbox.length; i++) {
            editor.putBoolean("checkbox" + i, checkbox[i].isChecked());
        }

        editor.putInt("minPrice", slider.getCurrentMin());
        editor.putInt("maxPrice", slider.getCurrentMax());


        editor.apply();
    }


}
