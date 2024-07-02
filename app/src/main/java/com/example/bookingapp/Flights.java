package com.example.bookingapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookingapp.Adapter.ConstantDateItem;
import com.example.bookingapp.Adapter.ConstantTicketItem;
import com.example.bookingapp.Adapter.DateAdapter;
import com.example.bookingapp.Adapter.DateItem;
import com.example.bookingapp.Adapter.TicketAdapter;
import com.example.bookingapp.Adapter.TicketItem;
import com.example.bookingapp.Fragment.TransportBooking;

import java.util.ArrayList;

public class Flights extends AppCompatActivity{
    private RecyclerView dateRecyclerView;
    private DateAdapter dateAdapter;
    private RecyclerView ticketRecyclerView;
    private TicketAdapter ticketAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_flights);
        dateRecyclerView = findViewById(R.id.date_recycler_view);

        ArrayList<DateItem> dateItems
                = ConstantDateItem.getDateItem();
        dateRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        dateAdapter = new DateAdapter(dateItems, this);
        dateRecyclerView.setAdapter(dateAdapter);

        ticketRecyclerView = findViewById(R.id.ticket_recycler_view);

        ArrayList<TicketItem> ticketItems
                = ConstantTicketItem.getTicketItem();
        ticketRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        ticketAdapter = new TicketAdapter(ticketItems, this);
        ticketRecyclerView.setAdapter(ticketAdapter);
        ImageButton filter = findViewById(R.id.filter_button);
        filter.setOnClickListener(v -> {
            Intent intent = new Intent(this, Filters.class);
            startActivity(intent);
        });
    }

}