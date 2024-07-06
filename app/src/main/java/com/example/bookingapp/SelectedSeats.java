package com.example.bookingapp;

import static com.example.bookingapp.Adapter.DateAdapter.registerOnClickDateListener;
import static com.example.bookingapp.Adapter.SeatAdapter.registerOnClickSeatListener;
import static com.example.bookingapp.Adapter.TravellerAdapter.registerOnClickTravellerListener;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookingapp.Adapter.ConstantDateItem;
import com.example.bookingapp.Adapter.ConstantFlightInfo;
import com.example.bookingapp.Adapter.DateItem;
import com.example.bookingapp.Adapter.FlightInfo;
import com.example.bookingapp.Adapter.Seat;
import com.example.bookingapp.Adapter.SeatAdapter;
import com.example.bookingapp.Adapter.TicketItem;
import com.example.bookingapp.Adapter.Traveller;
import com.example.bookingapp.Adapter.TravellerAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SelectedSeats extends AppCompatActivity implements OnSeatClickListener{

    private TextView seatInfo;
    private FlightInfo mflightInfo;
    private TextView priceValue;
    private int totalPrice = 0;
    private int price_per_ticket;

    private Button continueBtn;
    private TicketItem ticket;
    private Data data;
    private ImageButton backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        registerOnClickSeatListener(this);
        setContentView(R.layout.activity_selected_seats);
        data = (Data) getIntent().getSerializableExtra("Information");
        ticket = (TicketItem) getIntent().getSerializableExtra("ticket");
        seatInfo = findViewById(R.id.your_seats_value);
        priceValue = findViewById(R.id.total_price_value);
        String price = ticket.getPrice();
        if (price.contains("$")){
            price = price.substring(1);
        }
        price_per_ticket = Integer.parseInt(price);

        continueBtn = findViewById(R.id.continue_button);
        backBtn = findViewById(R.id.back_button);
        backBtn.setOnClickListener(v -> {
                    onBackPressed();
        });

        continueBtn.setOnClickListener(v -> {
            int tmp = Integer.parseInt(data.getNumberOfPassengers());
            int j = 0;
            for (int i = 1; i <= tmp; i++) {
                if (ticket.getSeats().get(i) == null) {
                    Toast.makeText(SelectedSeats.this, "Please select all seats", Toast.LENGTH_SHORT).show();
                } else{
                    j++;
                }
            }
            if (j == tmp){
                Intent intent = new Intent(SelectedSeats.this, BoardingPass.class);
                intent.putExtra("Information", data);
                intent.putExtra("ticket", ticket);
                startActivity(intent);
            }
        });
        



        // Initialize the RecyclerView for travellers
        RecyclerView recyclerView = findViewById(R.id.travellerContainer);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        // Dummy data for demonstration
        List<Traveller> travellerList = new ArrayList<>();
        int t = Integer.parseInt(data.getNumberOfPassengers());
        for (int i = 1; i <= t; i++){
            if (i == 1) {
                travellerList.add(new Traveller(i,true));
            }else{
                travellerList.add(new Traveller(i,false));
            }
        }


        // Initialize the adapter with the data
        TravellerAdapter adapter = new TravellerAdapter(travellerList);
        recyclerView.setAdapter(adapter);

        // Initialize the RecyclerView for seats
        RecyclerView seatRecyclerView = findViewById(R.id.seatRecyclerView);
        seatRecyclerView .setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        ArrayList<FlightInfo> flightInfo = ConstantFlightInfo.getFlightInfo();

        for (int i = 0; i < flightInfo.size(); i++) {
            Log.d("index","onCreate: " + i);
            Log.d("FlightInfo", "onCreate: " + flightInfo.get(i).getName());
            Log.d("FlightInfo", "onCreate: " + ticket.getFlightNumber());
            if (flightInfo.get(i).getName().equals(ticket.getFlightNumber())) {
                Log.d("SelectedSeats", "onCreate: " + flightInfo.get(i).getName());
                mflightInfo = flightInfo.get(i);
                break;
            }
        }
        Log.d("info", "onCreate: " + mflightInfo);
        List<Seat> seatList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            if (i == 0){
                // Creating new Seat objects with initial statuses
                Seat seat = new Seat(Seat.AVAILABLE, Seat.AVAILABLE, Seat.AVAILABLE, Seat.AVAILABLE);
                seatList.add(seat);
            }else {
                HashMap<Integer,Boolean> m = mflightInfo.getSeat();
                Seat seat = new Seat();
                if (m.containsKey((i - 1) * 4 + 1)){
                    if (m.get((i - 1) * 4 + 1) == false){
                        seat.setStatus1(Seat.AVAILABLE);
                    }else{
                        seat.setStatus1(Seat.BOOKED);
                    }
                }
                if (m.containsKey((i - 1) * 4 + 2)){
                    if (m.get((i-1) * 4 + 2) == false){
                        seat.setStatus2(Seat.AVAILABLE);
                    }else{
                        seat.setStatus2(Seat.BOOKED);
                    }
                }
                if (m.containsKey((i-1) * 4 + 3)){
                    if (m.get((i-1) * 4 + 3) == false){
                        seat.setStatus3(Seat.AVAILABLE);
                    }else{
                        seat.setStatus3(Seat.BOOKED);
                    }
                }
                if (m.containsKey((i-1) * 4 + 4)){
                    if (m.get((i-1) * 4 + 4) == false){
                        seat.setStatus4(Seat.AVAILABLE);
                    }else{
                        seat.setStatus4(Seat.BOOKED);
                    }
                }
                seat.setNum(i); // Setting seat number, assuming seat numbers start from 1
                seatList.add(seat);
            }
        }
        SeatAdapter seatAdapter = new SeatAdapter(this,seatList);
        seatRecyclerView.setAdapter(seatAdapter);

    }

    @Override
    public void onSeatClick(String seatNumber, int passenger) {
        seatInfo.setText("Traveler " + passenger + "/" + seatNumber);
        ticket.setSeats(passenger,seatNumber);
        int cnt = 0;
        int tmp = Integer.parseInt(data.getNumberOfPassengers());
        for (int i = 1; i <= tmp; i++) {
            if (ticket.getSeats().get(i) != null) {
                cnt++;
            }
        }
        totalPrice = cnt * price_per_ticket;
        priceValue.setText(totalPrice + "$");
    }
}

