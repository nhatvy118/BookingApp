package com.example.bookingapp.Adapter;


import java.io.Serializable;

public class DateItem {
    private String day;
    private String date;

    public DateItem(String day, String date) {
        this.day = day;
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}


