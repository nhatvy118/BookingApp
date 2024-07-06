package com.example.bookingapp.Adapter;

public class Traveller {
    private int number;
    private Boolean isSelect;

    public Traveller(int number, Boolean isSelect) {
        this.number = number;
        this.isSelect = isSelect;
    }


    public int getNumber() {
        return number;
    }

    public Boolean getIsSelect() {
        return isSelect;
    }

    public void setIsSelect(Boolean isSelect) {
        this.isSelect = isSelect;
    }
}
