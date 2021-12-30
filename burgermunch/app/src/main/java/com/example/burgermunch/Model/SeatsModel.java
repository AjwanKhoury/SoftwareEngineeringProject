package com.example.burgermunch.Model;

import com.example.burgermunch.Object.ISeats;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Observable;

public class SeatsModel extends Observable implements ISeatsModel {
    private DatabaseReference databaseReference;
    private FirebaseAuth mAuth;

    public SeatsModel() {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        this.databaseReference = db.getReference("Seats");
        this.mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void init() {
    }

    @Override
    public void addSeats(ISeats se) {

        databaseReference.child(se.getPhoneNumber()).setValue(se).addOnSuccessListener(suc->{
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
