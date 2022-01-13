package com.example.burgermunch.Object;

import android.os.Build;
import androidx.annotation.RequiresApi;
import com.example.burgermunch.Domain.OrderDetails;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@RequiresApi(api = Build.VERSION_CODES.O)
public class Order implements IOrder{
    private final String date = java.time.LocalDate.now().toString();
    private String Status = "נשלח למסעדה";
    private String CusPhone;
    private String address;
    private int points;
    private int deliveryCost;
    private List<OrderDetails> meals;

    public Order(){
        Status ="";
        CusPhone ="";
        address ="";
        deliveryCost = 0;
        points = 0;
        meals = new ArrayList<OrderDetails>();
    }

    public Order(String Cus,String add,int dc, List<OrderDetails> list){
        this.CusPhone= Cus;
        this.address=add;
        this.meals = list;
        this.deliveryCost=dc;
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
    public int getPoints() {
        return this.points;
    }
    public void setPoints(){
        this.points = points + getTotalPrice()/10;
    }

    @Override
    public int getTotalPrice() {
        if(meals.isEmpty()) return 0;
        int price=0;
        for (int i=0; i<meals.size(); i++){
            price += meals.get(i).getFee();
        }
        return price+deliveryCost;
    }



}
