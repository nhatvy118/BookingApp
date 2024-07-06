package com.example.bookingapp.Adapter;

import java.util.ArrayList;
import java.util.HashMap;

public class ConstantFlightInfo {
    public static ArrayList<FlightInfo> getFlightInfo() {
        ArrayList<FlightInfo> seatInfo = new ArrayList<>();

        // Define constant flight data with 28 seats each
        HashMap<Integer, Boolean> seats1 = new HashMap<>();
        for (int i = 1; i <= 27; i++) {
            seats1.put(i, i % 5 == 0); // Even seats are true, odd seats are false
        }
        FlightInfo flight1 = new FlightInfo("VJ123", seats1);
        seatInfo.add(flight1);

        HashMap<Integer, Boolean> seats2 = new HashMap<>();
        for (int i = 1; i <= 27; i++) {
            seats2.put(i, i % 3 == 0); // Seats divisible by 3 are true, others are false
        }
        FlightInfo flight2 = new FlightInfo("VNA45", seats2);
        seatInfo.add(flight2);

        HashMap<Integer, Boolean> seats3 = new HashMap<>();
        for (int i = 1; i <= 27; i++) {
            seats3.put(i, i % 4 == 0); // Seats divisible by 4 are true, others are false
        }
        FlightInfo flight3 = new FlightInfo("VJ45", seats3);
        seatInfo.add(flight3);

        HashMap<Integer, Boolean> seats4 = new HashMap<>();
        for (int i = 1; i <= 27; i++) {
            seats4.put(i, i % 5 == 0); // Seats divisible by 5 are true, others are false
        }
        FlightInfo flight4 = new FlightInfo("FL789", seats4);
        seatInfo.add(flight4);



        return seatInfo;
    }
}
