package com.example.bookingapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookingapp.Adapter.ConstantDateItem;
import com.example.bookingapp.Adapter.ConstantTicketItem;
import com.example.bookingapp.Adapter.DateAdapter;
import com.example.bookingapp.Adapter.DateItem;
import com.example.bookingapp.Adapter.TicketAdapter;
import com.example.bookingapp.Adapter.TicketItem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static com.example.bookingapp.Adapter.DateAdapter.registerOnClickDateListener;

public class Flights extends AppCompatActivity implements OnClickDateListener {
    private RecyclerView dateRecyclerView;
    private DateAdapter dateAdapter;
    private RecyclerView ticketRecyclerView;
    private TicketAdapter ticketAdapter;
    private TextView flightCount;
    private String selectedDate;

    private static final int FILTER_REQUEST_CODE = 1; // Choose a request code

    private String startTime;
    private String endTime;
    private String option1;
    private String option2;
    private int maxPrice;
    private int minPrice;

    private String isFilter;
    private ImageButton backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        registerOnClickDateListener(this);
        setContentView(R.layout.activity_flights);
        Data data = (Data) getIntent().getSerializableExtra("Information");
        String tmp = data.getDepartureDate();
        dateRecyclerView = findViewById(R.id.date_recycler_view);
        ticketRecyclerView = findViewById(R.id.ticket_recycler_view);
        ImageButton filter = findViewById(R.id.filter_button);
        backBtn = findViewById(R.id.back_button);
        backBtn.setOnClickListener(v -> {
            onBackPressed();
        });

        ArrayList<DateItem> dateItems = ConstantDateItem.getDateItems(30);
        dateRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        dateAdapter = new DateAdapter(dateItems, this, tmp); // Initially, set the departure datetime
        dateRecyclerView.setAdapter(dateAdapter);

        flightCount = findViewById(R.id.flight_count);



        filter.setOnClickListener(v -> {
            Intent intent = new Intent(this, Filters.class);
            startActivityForResult(intent, FILTER_REQUEST_CODE);
        });

    }


    @Override
    public void onClickDate(String dateTime) {
        filterData(dateTime);
        selectedDate = dateTime;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == FILTER_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            // Get filter data from the Intent
            startTime = data.getStringExtra("startTime");
            endTime = data.getStringExtra("endTime");
            option1 = data.getStringExtra("option1");
            option2 = data.getStringExtra("option2");
            maxPrice = data.getIntExtra("maxPrice", 0);
            minPrice = data.getIntExtra("minPrice", 0);
            isFilter = data.getStringExtra("IsFilters");
        }
        filterData(selectedDate);
    }
    // Function to check if timeToCheck is between startTime and endTime
    private boolean isTimeBetween(String timeToCheck, String startTime, String endTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
        try {
            Date timeToCheckDate = sdf.parse(timeToCheck);
            Date startTimeDate = sdf.parse(startTime);
            Date endTimeDate = sdf.parse(endTime);

            Calendar calendar = Calendar.getInstance();

            // If end time is before start time, it means it is on the next day
            if (endTimeDate.before(startTimeDate)) {
                // Handle crossing midnight
                calendar.setTime(startTimeDate);
                calendar.add(Calendar.DAY_OF_YEAR, -1);
                startTimeDate = calendar.getTime();

                calendar.setTime(endTimeDate);
                calendar.add(Calendar.DAY_OF_YEAR, 1);
                endTimeDate = calendar.getTime();
            }

            return timeToCheckDate.after(startTimeDate) && timeToCheckDate.before(endTimeDate);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
            return false;
        }
    }
    public void filterData(String dateTime){
        Data data = (Data) getIntent().getSerializableExtra("Information");
        ArrayList<TicketItem> ticketItems = ConstantTicketItem.getTicketItem();
        ArrayList<TicketItem> customArrayList = new ArrayList<>();
        for (TicketItem item : ticketItems) {
            if (Objects.equals(item.getDateTime(), dateTime) && (Objects.equals(item.getToAirport(), data.getSelectedAirportTo()))&&
                    (Objects.equals(item.getFromAirport(), data.getSelectedAirportFrom()))) {
                // Apply filter if set
                if (Objects.equals(isFilter, "IsFilter")) {
                    Log.d("Filter", "Start time: " + startTime + ", End time: " + endTime);
                    Log.d("Filter",maxPrice + " " + minPrice);
                    if (!Objects.equals(option1, "null") && !Objects.equals(option2, "null")) {
                        if (isTimeBetween(item.getDepartureTime(), startTime,endTime) && (isPriceBetween(item.getPrice(), minPrice, maxPrice))) {
                            customArrayList.add(item);
                        }
                    }
                    else if (!Objects.equals(option1, "null")) {
                        if (isTimeBetween(item.getDepartureTime(), startTime,endTime)) {
                            customArrayList.add(item);
                        }
                    }else{
                        if (!Objects.equals(option2, "null")){
                            if (isPriceBetween(item.getPrice(), minPrice, maxPrice)) {
                                customArrayList.add(item);
                            }
                        }
                    }

                }else{
                    customArrayList.add(item);
                }

            }
        }
        String selectedAirportFrom = data.getSelectedAirportFrom();
        String cityFrom = selectedAirportFrom.substring(0, selectedAirportFrom.indexOf('(')).trim();
        String selectedAirportTo = data.getSelectedAirportTo();
        String cityTo = selectedAirportTo.substring(0, selectedAirportTo.indexOf('(')).trim();
        flightCount.setText(customArrayList.size() + " flights available from " + cityFrom + " to " + cityTo);
        ticketRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        ticketAdapter = new TicketAdapter(customArrayList, this,data);
        ticketRecyclerView.setAdapter(ticketAdapter);

    }

    private boolean isPriceBetween(String price, int minPrice, int maxPrice) {
        try {
            if (price.startsWith("$")) {
                price = price.substring(1);
            }
            int priceInt = Integer.parseInt(price);
            return priceInt >= minPrice && priceInt <= maxPrice;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}
