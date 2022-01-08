package com.example.burgermunch.Controller;

import android.util.Log;

import com.example.burgermunch.View.ILoginView;
import com.example.burgermunch.Model.ILoginModel;
import com.example.burgermunch.Model.LoginModel;
import com.example.burgermunch.Object.Customer;

import java.util.Observable;
import java.util.Observer;

public class LoginController implements ILoginController, Observer {
    private ILoginView view;
    private ILoginModel model;

    public LoginController(ILoginView view){
        this.view = view;
        model = new LoginModel();
        ((LoginModel)model).addObserver(this);
    }


    @Override
    public void OnLogin(String email, String password) {
        Customer cus = new Customer(email,password);
        int LoginCode = cus.isValid(email,password);

        if (LoginCode == 0)
            Log.e("user", "problem in login");

        if(LoginCode == 1)
            view.LoginFail("Email is required");

        if(LoginCode == 2)
            view.LoginFail("Password is required");

        if(LoginCode ==3)
            view.LoginFail("Invalid email");

        if(LoginCode == -1)
            model.CheckCustomer(cus);
    }

    @Override
    public void update(Observable o, Object arg) {
        int keyCode = (int) arg;
        if(keyCode == -1){
            view.LoginSuc("Successfully logged in!");
        }
        else if (keyCode == 1){
            view.LoginFail("Email or password are not correct!");
        }
    }
}
