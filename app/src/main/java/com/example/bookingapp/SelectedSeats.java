package com.example.bookingapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookingapp.Adapter.Seat;
import com.example.bookingapp.Adapter.SeatAdapter;
import com.example.bookingapp.Adapter.TravellerAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectedSeats extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_seats);

        // Enable edge to edge display if needed
        // EdgeToEdge.enable(this);

        // Initialize the RecyclerView for travellers
        RecyclerView recyclerView = findViewById(R.id.travellerContainer);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        // Dummy data for demonstration
        List<Integer> travellerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        // Initialize the adapter with the data
        TravellerAdapter adapter = new TravellerAdapter(travellerList);
        recyclerView.setAdapter(adapter);

        // Initialize the RecyclerView for seats
        RecyclerView seatRecyclerView = findViewById(R.id.seatRecyclerView);
        seatRecyclerView .setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        List<Seat> seatList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            if(i==0){
                // Creating new Seat objects with initial statuses
                Seat seat = new Seat(Seat.AVAILABLE, Seat.AVAILABLE, Seat.AVAILABLE, Seat.AVAILABLE);
                seatList.add(seat);
            }else {
                // Creating new Seat objects with initial statuses
                Seat seat = new Seat(Seat.AVAILABLE, Seat.AVAILABLE, Seat.AVAILABLE, Seat.AVAILABLE);
                seat.setNum(i); // Setting seat number, assuming seat numbers start from 1
                seatList.add(seat);
            }
        }



        SeatAdapter seatAdapter = new SeatAdapter(this,seatList);
        seatRecyclerView.setAdapter(seatAdapter);
    }
}

