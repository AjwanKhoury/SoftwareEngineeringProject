package com.example.burgermunch.Object;

public interface ISeats {
    public int getNumSeats();
    public void setNumSeats(int num);
    public String getFullName();
    public void setFullName(String s);
    public String getPhoneNumber();
    public String getTime();
    public String getDate();
    public void setTime(String t);
    public boolean checkTime(String time);
    public boolean checkPhone(String phone);
    public int getStatus();
    public void setStatus(int status);
}
