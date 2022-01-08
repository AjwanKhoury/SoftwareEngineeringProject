package com.example.burgermunch.Controller;

import com.example.burgermunch.Domain.OrderDetails;
import com.example.burgermunch.Interface.IOrderController;
import com.example.burgermunch.Interface.IOrderView;
import com.example.burgermunch.Model.IOrderModel;
import com.example.burgermunch.Model.OrderModel;
import com.example.burgermunch.Object.Order;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class OrderController implements IOrderController, Observer {

    private IOrderView view;
    private IOrderModel model;

    public OrderController(IOrderView view){
        this.view = view;
        model = new OrderModel();
        ((OrderModel)model).addObserver(this);
    }

    @Override
    public void OnOrder(String Cus, String add,int dc, List<OrderDetails> list) {
        Order od = new Order(Cus,add,dc,list);
        model.addOrder(od);
    }

    @Override
    public void update(Observable o, Object arg) {

    }

}
