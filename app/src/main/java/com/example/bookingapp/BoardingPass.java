package com.example.bookingapp;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.bookingapp.Adapter.TicketItem;

public class BoardingPass extends AppCompatActivity {

    private Data data;
    private TicketItem ticket;
    private ImageButton backbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_boarding_pass);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        backbtn = findViewById(R.id.back_button);
        backbtn.setOnClickListener(v -> {
            onBackPressed();
        });
        data = (Data) getIntent().getSerializableExtra("Information");
        ticket = (TicketItem) getIntent().getSerializableExtra("ticket");

        TextView fromCode = findViewById(R.id.fromCode);
        TextView fromName = findViewById(R.id.fromName);
        TextView toCode = findViewById(R.id.toCode);
        TextView toName = findViewById(R.id.toName);
        TextView passenger = findViewById(R.id.Passenger_value);
        TextView flightnum = findViewById(R.id.ticket_value);
        TextView Class = findViewById(R.id.class_value);
        TextView seat = findViewById(R.id.seat_value);
        TextView date = findViewById(R.id.dateValue);
        TextView time = findViewById(R.id.departureValue);
        TextView FlightName = findViewById(R.id.airportname);

        fromCode.setText(ticket.getFromAirportCode());
        fromName.setText(ticket.getFromCity());
        toCode.setText(ticket.getToAirportCode());
        toName.setText(ticket.getToCity());
        passenger.setText(data.getNumberOfPassengers() + " Adult");
        flightnum.setText(ticket.getFlightNumber());
        Class.setText(data.getClassType());
        date.setText(ticket.getDate());
        time.setText(ticket.getDepartureTime());
        FlightName.setText("Viet Nam Airways Flight " + ticket.getFlightNumber());
        String S = "";
        int size = Integer.parseInt(data.getNumberOfPassengers());
        for (int i = 1; i <= size; i++) {
            if (i == size)
                S += ticket.getSeats().get(i);
            else {
                S += ticket.getSeats().get(i) + ",";
            }
        }
        seat.setText(S);


    }
}