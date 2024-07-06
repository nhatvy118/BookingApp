package com.example.bookingapp;


import java.io.Serializable;

public class Data implements Serializable {
    private String departureDate;
    private String returnDate;
    private String selectedAirportFrom;
    private String selectedAirportTo;
    private String numberOfPassengers;
    private String numberOfChildren;
    private String classType;
    private String transportType;



    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String date) {
        departureDate = date;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String date) {
        returnDate = date;
    }

    public String getSelectedAirportFrom() {
        return selectedAirportFrom;
    }

    public void setSelectedAirportFrom(String airport) {
        selectedAirportFrom = airport;
    }

    public String getSelectedAirportTo() {
        return selectedAirportTo;
    }

    public void setSelectedAirportTo(String airport) {
        selectedAirportTo = airport;
    }

    public String getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(String numPassengers) {
        numberOfPassengers = numPassengers;
    }

    public String getNumberOfChildren() {
        return numberOfChildren;
    }

    public void setNumberOfChildren(String numChildren) {
        numberOfChildren = numChildren;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String type) {
        classType = type;
    }

    public String getTransportType() {
        return transportType;
    }

    public void setTransportType(String type) {
        transportType = type;
    }
}
