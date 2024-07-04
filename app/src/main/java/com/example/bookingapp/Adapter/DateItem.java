package com.example.bookingapp.Adapter;

public class DateItem {
    private String day;
    private String date;
    private String datetime; // New attribute for datetime
    private boolean isSelected;

    public DateItem(String day, String date, String datetime) {
        this.day = day;
        this.date = date;
        this.datetime = datetime;
        this.isSelected = false; // Initialize isSelected to false
    }
    public boolean getSelected() {
        return isSelected;
    }
    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
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

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
}
