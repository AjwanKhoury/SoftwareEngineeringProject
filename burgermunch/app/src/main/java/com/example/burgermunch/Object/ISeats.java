package com.example.burgermunch.Object;

public interface ISeats {
    public int getNumSeats();
    public String getFullName();
    public String getPhoneNumber();
    public String getTime();
    int isValid();
    public boolean checkTime(String time);
    public boolean checkPhone(String phone);
}
