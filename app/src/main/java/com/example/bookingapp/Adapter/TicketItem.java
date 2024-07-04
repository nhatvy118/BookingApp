package com.example.bookingapp.Adapter;

public class TicketItem {
    private String date;
    private String departureTime;
    private String price;
    private String flightNumber;
    private String fromCity;
    private String toCity;
    private String fromAirportCode;
    private String toAirportCode;

    private String dateTime;
    private String fromAirport;
    private String toAirport;


    public TicketItem(String dateTime, String departureTime, String price, String flightNumber, String fromCity, String toCity,
                      String fromAirportCode, String toAirportCode, String date, String fromAirport, String toAirport) {
        this.dateTime = dateTime;
        this.departureTime = departureTime;
        this.price = price;
        this.flightNumber = flightNumber;
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.fromAirportCode = fromAirportCode;
        this.toAirportCode = toAirportCode;
        this.date = date;
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public String getFromAirportCode() {
        return fromAirportCode;
    }

    public void setFromAirportCode(String fromAirportCode) {
        this.fromAirportCode = fromAirportCode;
    }

    public String getToAirportCode() {
        return toAirportCode;
    }

    public void setToAirportCode(String toAirportCode) {
        this.toAirportCode = toAirportCode;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getFromAirport() {
        return fromAirport;
    }

    public void setFromAirport(String fromAirport) {
        this.fromAirport = fromAirport;
    }

    public String getToAirport() {
        return toAirport;
    }

    public void setToAirport(String toAirport) {
        this.toAirport = toAirport;
    }
}
