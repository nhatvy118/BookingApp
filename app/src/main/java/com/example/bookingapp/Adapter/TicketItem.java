package com.example.bookingapp.Adapter;



public class TicketItem {
    private String date;
    private String departureTime;
    private String price;
    private String flightNumber;

    public TicketItem(String date, String departureTime, String price, String flightNumber) {
        this.date = date;
        this.departureTime = departureTime;
        this.price = price;
        this.flightNumber = flightNumber;
    }

    public String getDate() {
        return date;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getPrice() {
        return price;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    // Setters can be added if needed
}