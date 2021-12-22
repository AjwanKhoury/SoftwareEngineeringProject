package com.example.burgermunch.Object;

import static com.example.burgermunch.Object.Customer.onlyAlphabetic;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;

public class Seats implements ISeats{
    private int num_seats;
    private String full_name;
    private String phone_number;
    private String time;

    public Seats(){
        num_seats =0;
        full_name ="";
        phone_number = "";
        time = "";
    }

    public Seats(int seats , String fn , String pn , String time){
        this.num_seats = seats;
        this.full_name = fn;
        this.phone_number = pn;
        this.time = time;
    }

    public HashMap<String,Object> toMap () {
        HashMap<String, Object> Seats = new HashMap<>();
        Seats.put("num_seats", this.num_seats);
        Seats.put("full_name", this.full_name);
        Seats.put("phone_number", this.phone_number);
        return Seats;
    }

    @Override
    public int getNumSeats() {
        return num_seats;
    }

    @Override
    public String getFullName() {
        return full_name;
    }

    @Override
    public String getPhoneNumber() {
        return phone_number;
    }

    @Override
    public String getTime() { return time; }

    @Override
    public int isValid() {
        if(this == null)
            return 0;
        if(getNumSeats()>4)
            return 1;
        if(getFullName().length() < 2 || !onlyAlphabetic(getFullName()))
            return 2;
        if(getPhoneNumber().length() < 10)
            return 3;
        if(getNumSeats()<1)
            return 4;
        if(!checkTime(time))
            return 5;
        if(!checkPhone(getPhoneNumber()))
            return 6;
        return -1;
    }

    @Override
    public boolean checkTime(String time) {
        return time.matches("^([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$");
    }

    @Override
    public boolean checkPhone(String phone) {
        boolean flag = true;
        char temp;
        for (int i=0; i<phone.length(); i++) {
            temp = phone.charAt(i);
            if(!Character.isDigit(temp)) flag = false;
        }
        return flag;
    }


}
