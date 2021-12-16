package com.example.burgermunch.Controller;

import android.util.Log;
import com.example.burgermunch.Interface.IRegisterModel;
import com.example.burgermunch.Interface.IRegisterView;
import com.example.burgermunch.Model.RegisterModel;
import com.example.burgermunch.Object.Customer;

import java.util.Observable;
import java.util.Observer;

public class RegisterController implements IRegisterController, Observer {

    private IRegisterView view;
    private IRegisterModel model;

    public RegisterController(IRegisterView view) {
        this.view = view;
        model = new RegisterModel();

        ((RegisterModel)model).addObserver(this);
    }

    @Override
    public void OnSignUp(String full_name,String address, String phone_number, String email, String password) {
        Customer customer = new Customer(full_name,address, phone_number, email, password);
        int signupCode = customer.isValid();

        if(signupCode == 0){
            Log.e("user","user cant be null");
        }
        if(signupCode == 1){
            view.RegisterError("Full name problem");
        }

        if(signupCode == 2){
            view.RegisterError("Phone number is incorrect");
        }
        if(signupCode == 3){
            view.RegisterError("invalid email");
        }
        if(signupCode == 4){
            view.RegisterError("Password must be up than 6");
        }
        if(signupCode == 4){
            view.RegisterError("Must include address");
        }
        if(signupCode == -1){
            model.addCustomer(customer);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        int keyCode = (int) arg;
        if(keyCode == -1){
            view.RegisterSuccess("Successfully signed up!");
        }else if(keyCode == 1){
            Log.e("firebase", "the user added to the authentication but not to realtime database");
        }else if (keyCode == 2){
            view.RegisterError("Email already exists!");
        }

    }
}
