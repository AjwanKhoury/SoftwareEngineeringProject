package com.example.burgermunch.Interface;

import com.example.burgermunch.Domain.OrderDetails;

import java.util.List;

public interface IOrderController {
    public void OnOrder(String Cus , List<OrderDetails> list);
}
