package com.example.burgermunch.Object;

import android.os.Build;
import androidx.annotation.RequiresApi;
import com.example.burgermunch.Domain.OrderDetails;
import java.util.ArrayList;
import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.O)
public class Order implements IOrder{
    private final String date = java.time.LocalDate.now().toString();
    private String Status = "נשלח למסעדה";
    private String CusPhone;
    private String address;
    private List<OrderDetails> meals;

    public Order(){
        Status ="";
        CusPhone ="";
        address ="";
        meals = new ArrayList<OrderDetails>();
    }

    public Order(String Cus,String add, List<OrderDetails> list){
        this.CusPhone= Cus;
        this.address=add;
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
