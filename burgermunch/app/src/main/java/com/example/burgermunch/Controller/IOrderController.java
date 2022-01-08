package com.example.burgermunch.Controller;

import com.example.burgermunch.Domain.OrderDetails;
import com.example.burgermunch.Object.CCinfo;

import java.util.List;

public interface IOrderController {
    public void OnOrder(String Cus , String add, List<OrderDetails> list, CCinfo creditCard);
}
