package com.example.bookingapp.Adapter;


import android.widget.TextView;

public class Seat {
    public static final int AVAILABLE = 0;
    public static final int BOOKED = 1;
    public static final int SELECTED = 2;

    private TextView[] seats;
    private int status1;
    private int mTraveller1;
    private int status2;
    private int mTraveller2;
    private int status3;
    private int mTraveller3;
    private int status4;
    private int mTraveller4;

    private int num;

    public Seat(){
        this.status1 = Seat.AVAILABLE;
        this.status2 = Seat.AVAILABLE;
        this.status3 = Seat.AVAILABLE;
        this.status4 = Seat.AVAILABLE;
        this.mTraveller1 = 0;
        this.mTraveller2 = 0;
        this.mTraveller3 = 0;
        this.mTraveller4 = 0;
    }

    public Seat(int status1, int status2, int status3, int status4) {
        this.status1 = Seat.AVAILABLE;
        this.status2 = Seat.AVAILABLE;
        this.status3 = Seat.AVAILABLE;
        this.status4 = Seat.AVAILABLE;
        this.mTraveller1 = 0;
        this.mTraveller2 = 0;
        this.mTraveller3 = 0;
        this.mTraveller4 = 0;
    }

    public void setSeats(TextView[] seats) {
        this.seats = seats;
    }
    public TextView[] getSeats() {
        return seats;
    }
    public int getmTraveller1(){
        return mTraveller1;
    }
    public int getmTraveller2(){
        return mTraveller2;
    }
    public int getmTraveller3() {
        return mTraveller3;
    }
    public int getmTraveller4() {
        return mTraveller4;
    }

    public void setmTraveller1(int num){
        this.mTraveller1 = num;
    }
    public void setmTraveller2(int num){
        this.mTraveller2 = num;
    }
    public void setmTraveller3(int num) {
        this.mTraveller3 = num;
    }
    public void setmTraveller4(int num) {
        this.mTraveller4 = num;
    }

    public int getStatus1(){
        return status1;
    }
    public int getStatus2(){
        return status2;
    }

    public int getStatus3(){
        return status3;
    }

    public int getStatus4(){
        return status4;
    }
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
    public void setStatus1(int state){
        this.status1 = state;
    }
    public void setStatus2(int state){
        this.status2 = state;
    }
    public void setStatus3(int state){
        this.status3 = state;
    }
    public void setStatus4(int state) {
        this.status4 = state;
    }


}



