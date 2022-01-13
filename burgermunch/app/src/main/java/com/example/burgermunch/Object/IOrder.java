package com.example.burgermunch.Object;

import com.example.burgermunch.Domain.OrderDetails;

import java.util.List;

public interface IOrder {
    public String getDate();
    public String getStatus();
    public String getCusPhone();
    public int getTotalPrice();
    public int getPoints();
    public List<OrderDetails> getList();

}
