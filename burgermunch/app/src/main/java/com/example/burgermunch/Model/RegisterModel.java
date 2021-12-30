package com.example.burgermunch.Model;

import com.example.burgermunch.Object.ICustomer;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Observable;

public class RegisterModel extends Observable implements IRegisterModel {
    private DatabaseReference databaseReference;
    private FirebaseAuth mAuth;


    public RegisterModel() {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        this.databaseReference = db.getReference("Customer");
        this.mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void init() {
    }

    @Override
    public void addCustomer(ICustomer cus) {
        mAuth.createUserWithEmailAndPassword(cus.getEmail(), cus.getPassword())
                .addOnSuccessListener(suc->{
                    databaseReference.child(cus.getPhoneNumber()).setValue(cus)
                            .addOnSuccessListener(suc2->{
                                //success to add user to authentication database and realtime database.users.
                                setChanged();
                                notifyObservers(-1);

                            }).addOnFailureListener(fail->{
                                //success to add user to authentication database but not to the realtime database.users.
                                setChanged();
                                notifyObservers(1);
                            });

                }).addOnFailureListener(fail->{
                    // failed to add user to authentication database - probably he is exist already.
                    setChanged();
                    notifyObservers(2);
                });

    }
}


