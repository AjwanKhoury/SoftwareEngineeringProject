package com.example.burgermunch.Model;

import com.example.burgermunch.Domain.IOrderDetails;
import com.example.burgermunch.Object.IOrder;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Observable;

public class OrderModel extends Observable implements IOrderModel {
    private DatabaseReference databaseReference;
    private FirebaseAuth mAuth;

    public OrderModel(){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        this.databaseReference = db.getReference("Orders");
        this.mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void init() {
    }

    @Override
    public void addOrder(IOrder od) {
        databaseReference.push().setValue(od).addOnSuccessListener(suc->{
            //success to add data to the realtime database
            setChanged();
            notifyObservers(-1);
        }).addOnFailureListener(fail->{
            //failed to put data on realtime database
            setChanged();
            notifyObservers(1);
        });
    }
}
