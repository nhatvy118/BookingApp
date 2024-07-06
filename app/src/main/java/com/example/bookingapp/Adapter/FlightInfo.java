package com.example.bookingapp.Adapter;

import java.util.HashMap;

public class FlightInfo {
    private String name;
    private HashMap<Integer, Boolean> seat;

    public FlightInfo(String name, HashMap<Integer, Boolean> seat) {
        this.name = name;
        this.seat = seat;
    }

    // Getters and setters if needed
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<Integer, Boolean> getSeat() {
        return seat;
    }

    public void setSeat(HashMap<Integer, Boolean> seat) {
        this.seat = seat;
    }
}
