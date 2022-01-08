package com.example.burgermunch.Controller;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.example.burgermunch.Domain.OrderDetails;
import com.example.burgermunch.Object.CCinfo;
import com.example.burgermunch.View.IOrderView;
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

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void OnOrder(String Cus, String add, List<OrderDetails> list, CCinfo cardInfo) {
        Order od = new Order(Cus,add,list);
        int orderCode = isValid(cardInfo , add);
        if(orderCode == 0){
            view.OrderError("מספר טלפון אינו תקין (10 ספרות בלבד)");
        }
        if(orderCode == 1){
            view.OrderError("אנא הזן 3 ספרות בגב הכרטיס");
        }
        if(orderCode == 2){
            view.OrderError("אנא הזן שם מלא");
        }
        if(orderCode == 3){
            view.OrderError("תוקף אשראי לא תקין");
        }
        if(orderCode == 4){
            view.OrderError("מספר כרטיס אשראי לא תקין");
        }
        if(orderCode == 5){
            view.OrderError("אנא הזן כתובת למשלוח");
        }
        if(orderCode == -1){
            model.addOrder(od);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private int isValid(CCinfo card , String address) {
        if(!checkPhone(card.getPhoneNum())) return 0;
        if(!checkCVV(card.getCvv())) return 1;
        if(!checkName(card.getName())) return 2;
        if(!checkExpDate(card.getExpDate())) return 3;
        if(!checkCreditNum(card.getCcNum())) return 4;
        if(address.length()<1) return 5;
        return -1;
    }

    @Override
    public void update(Observable o, Object arg) {
        int keyCode = (int) arg;
        if(keyCode == -1){
            view.OrderSuccess("Order Confirmed!");
        }else if(keyCode == 1){
            Log.e("firebase", "failed to put data on realtime database");
        }
    }
    //checks functions for isValid
    private boolean checkPhone(String s){
        if(s.length()<10) return false;
        for (int i=0; i<s.length(); i++) {
            if(!Character.isDigit(s.charAt(i))) return false;
        }
        return true;
    }
    private boolean checkName(String s) {
        char[] chars = s.toCharArray();
        for(char c : chars){
            if(Character.isDigit(c))
                return false;
        }
        return true;
    }
    private boolean checkCVV(String s){
        if(s.length()<3) return false;
        for (int i=0; i<s.length(); i++){
            if(!Character.isDigit(s.charAt(i))) return false;
        }
        return true;
    }
    private boolean checkExpDate(String s){
        return s.matches("^(0[1-9]|1[0-2])/[0-9][0-9]$");
    }
    private boolean checkCreditNum(String s) {
        if(s.length()<8) return false;
        for (int i=0; i<s.length(); i++){
            if(!Character.isDigit(s.charAt(i))) return false;
        }
        return true;
    }


}
