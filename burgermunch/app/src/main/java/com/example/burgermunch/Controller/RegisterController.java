package com.example.burgermunch.Controller;

import android.util.Log;

import com.example.burgermunch.View.IRegisterView;
import com.example.burgermunch.Model.IRegisterModel;
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
    public void OnRegister(String full_name,String address, String phone_number, String email, String password) {
        Customer customer = new Customer(full_name,address, phone_number, email, password);
        int signupCode = isValid(customer);

        if(signupCode == 0){
            Log.e("customer","חובה להזין שם");
        }
        if(signupCode == 1){
            view.RegisterError("שם לא תקין");
        }

        if(signupCode == 2){
            view.RegisterError("מספר פלאפון לא תקין");
        }
        if(signupCode == 3){
            view.RegisterError("אימייל לא תקין");
        }
        if(signupCode == 4){
            view.RegisterError("סיסמא חייבת להיות מעל 6 ספרות");
        }
        if(signupCode == 4){
            view.RegisterError("חובה להזין כתובת");
        }
        if(signupCode == -1){
            model.addCustomer(customer);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        int keyCode = (int) arg;
        if(keyCode == -1){
            view.RegisterSuccess("נרשמת בהצלחה");
        }else if(keyCode == 1){
            Log.e("firebase", "the user added to the authentication but not to realtime database");
        }else if (keyCode == 2){
            view.RegisterError("אימייל כבר קיים");
        }
    }
    public int isValid(Customer c) {
        if(c == null)
            return 0;
        if(c.getFullName().length() < 2 || !c.onlyAlphabetic(c.getFullName()))
            return 1;
        if(c.getPhoneNumber().length() != 10)
            return 2;
        if(!c.isEmail(c.getEmail()))
            return 3;
        if (c.getPassword().length() < 6)
            return 4;
        if(c.getAddress()==null)
            return 5;
        return -1;
    }
}
