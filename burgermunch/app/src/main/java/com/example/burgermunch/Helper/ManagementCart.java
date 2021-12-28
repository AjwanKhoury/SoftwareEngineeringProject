package com.example.burgermunch.Helper;

import android.content.Context;
import android.widget.Toast;

import com.example.burgermunch.Domain.OrderDetails;

import java.util.ArrayList;

public class ManagementCart{
    private Context context;
    private TinyDB tinyDB;

    public ManagementCart(Context context) {
        this.context = context;
        this.tinyDB = new TinyDB(context);
    }

    public void insertFood(OrderDetails item) {
        ArrayList<OrderDetails> listFood = getListCart();
        listFood.add(item);
        tinyDB.putListObject("CardList", listFood);
        Toast.makeText(context, "נוסף לעגלה", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<OrderDetails> getListCart() {
        return tinyDB.getListObject("CardList");
    }

    public void minusNumberFood(ArrayList<OrderDetails> listfood, int position, ChangeNumberItemsListener changeNumberItemsListener) {
        listfood.remove(position);
        tinyDB.putListObject("CardList", listfood);
        changeNumberItemsListener.changed();
    }



    public Double getTotalFee() {
        ArrayList<OrderDetails> listfood2 = getListCart();
        double fee = 0;
        for (int i = 0; i < listfood2.size(); i++) {
            fee = fee + (listfood2.get(i).getFee());
        }
        return fee;
    }
}
