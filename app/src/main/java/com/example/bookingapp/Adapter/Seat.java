package com.example.bookingapp.Adapter;



public class Seat {
    public static final int AVAILABLE = 0;
    public static final int BOOKED = 1;
    public static final int SELECTED = 2;


    private int status1;
    private int status2;
    private int status3;
    private int status4;

    private int num;

    public Seat(int status1, int status2, int status3, int status4) {
        this.status1 = Seat.AVAILABLE;
        this.status2 = Seat.AVAILABLE;
        this.status3 = Seat.AVAILABLE;
        this.status4 = Seat.AVAILABLE;
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



