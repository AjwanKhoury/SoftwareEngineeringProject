package com.example.burgermunch.Object;

import com.example.burgermunch.Domain.OrderDetails;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order implements IOrder{
    private SimpleDateFormat Now;
    private String date;
    private String Status;
    private String CusPhone;
    private int TotalPrice;
    private List<OrderDetails> meals;

    public Order(){
        Date date = new Date();
        Status ="נשלח למסעדה";
        CusPhone ="";
        meals = new ArrayList<OrderDetails>();
    }

    public Order(String Cus, List<OrderDetails> list){
        this.date= Now.format(date);
        this.CusPhone= Cus;
        this.meals = list;
    }


    @Override
    public String getDate() {
        return date;
    }

    @Override
    public String getStatus() {
        return Status;
    }
    public void setStatus(String status) {
        this.Status = status;
    }

    @Override
    public String getCusPhone() {
        return CusPhone;
    }
    public void setCusPhone(String cusPhone) {
        this.CusPhone = cusPhone;
    }

    @Override
    public List<OrderDetails> getList() { return meals; }
    public void setList(List<OrderDetails> OdL){ this.meals= OdL; }


    @Override
    public int getTotalPrice() {
        if(meals.isEmpty()) return 0;
        int price=0;
        for (int i=0; i<meals.size(); i++){
            price += meals.get(i).getFee();
        }
        return price;
    }


}
