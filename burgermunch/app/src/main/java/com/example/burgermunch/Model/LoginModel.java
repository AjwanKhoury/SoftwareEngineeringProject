package com.example.burgermunch.Model;

import com.example.burgermunch.Object.ICustomer;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import java.util.Observable;

public class LoginModel extends Observable implements ILoginModel {

    private FirebaseAuth mAuth;

    public LoginModel(){
        this.mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void CheckCustomer(ICustomer cus) {
        mAuth.signInWithEmailAndPassword(cus.getEmail(), cus.getPassword())
                .addOnCompleteListener((OnCompleteListener<AuthResult>) task -> {
                    if(task.isSuccessful()){
                        setChanged();
                        notifyObservers(-1);
                    } else {
                        setChanged();
                        notifyObservers(1);
                    }
                });
    }
}
