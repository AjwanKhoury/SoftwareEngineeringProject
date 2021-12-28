package com.example.burgermunch.Controller;

import com.example.burgermunch.Interface.IOrderDetailController;
import com.example.burgermunch.Interface.IOrderView;
import com.example.burgermunch.Interface.ISeatsView;
import com.example.burgermunch.Model.IOrderModel;
import com.example.burgermunch.Model.ISeatsModel;
import com.example.burgermunch.Model.OrderModel;
import com.example.burgermunch.Model.SeatsModel;

import java.util.Observable;
import java.util.Observer;

public class OrderDetailController implements IOrderDetailController, Observer {

    private IOrderView view;
    private IOrderModel model;

    public OrderDetailController(IOrderView view){
        this.view = view;
        model = new OrderModel();
        ((OrderModel)model).addObserver(this);
    }

    @Override
    public void OnOrder(String title, String pic, String description, int fee) {

    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
