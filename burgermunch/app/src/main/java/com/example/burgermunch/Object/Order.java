package com.example.burgermunch.Object;

import com.example.burgermunch.Domain.OrderDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

public class Order implements IOrder{
    private String Date;
    private String Status;
    private String CusPhone;
    private String OrderID;
    private int TotalPrice;
    private List<OrderDetails> meals;

    public Order(){
        Date ="";
        Status ="";
        CusPhone ="";
        OrderID ="";
        meals = new ArrayList<OrderDetails>();
    }

    public Order(String Da,String St, String Cus, String Or , List<OrderDetails> list){
        this.Date= Da;
        this.Status= St;
        this.CusPhone= Cus;
        this.OrderID= Or;
        this.meals = list;
    }


    @Override
    public String getDate() {
        return Date;
    }
    public void setDate(String Sd){
        this.Date=Sd;
    }

    @Override
    public String getStatus() {
        return Status;
    }
    public void setStatus(String status) {
        this.Status = status;
    }

    @Override
    public String getOrderID() {
        return OrderID;
    }
    public void setOrderID(String orderID) {
        this.OrderID = orderID;
    }

    @Override
    public String getCusPhone() {
        return CusPhone;
    }

    @Override
    public int getTotalPrice() {
        if(meals.isEmpty()) return 0;
        int price=0;
        for (int i=0; i<meals.size(); i++){
            price += meals.get(i).getFee();
        }
        return price;
    }

    public void setCusPhone(String cusPhone) {
        this.CusPhone = cusPhone;
    }

}
