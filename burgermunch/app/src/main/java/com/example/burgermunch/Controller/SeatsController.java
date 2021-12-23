package com.example.burgermunch.Controller;

import android.util.Log;

import com.example.burgermunch.Interface.ISeatsController;
import com.example.burgermunch.Interface.ISeatsView;
import com.example.burgermunch.Model.ISeatsModel;
import com.example.burgermunch.Model.SeatsModel;
import com.example.burgermunch.Object.Seats;

import java.util.Observable;
import java.util.Observer;

public class SeatsController implements ISeatsController , Observer {

    private ISeatsView view;
    private ISeatsModel model;

    public SeatsController(ISeatsView view){
        this.view = view;
        model = new SeatsModel();
        ((SeatsModel)model).addObserver(this);
    }


    @Override
    public void OnSeats(int seats, String fn, String pn , String time) {
        Seats st = new Seats(seats , fn , pn , time);
        int seatsCode = st.isValid();

        if(seatsCode == 0){
            Log.e("st","Seats order can not be null");
        }
        if(seatsCode == 1){
            view.SeatsError("Can not order 5 seats or above , Please read description");
        }
        if(seatsCode == 2){
            view.SeatsError("Full name error");
        }
        if(seatsCode == 3){
            view.SeatsError("Invalid phone number(less then 10 digits)");
        }
        if(seatsCode == 4){
            view.SeatsError("Must order at least one seat");
        }
        if(seatsCode == 5){
            view.SeatsError("Please insert a valid hour");
        }
        if(seatsCode == 6){
            view.SeatsError("Please enter digits only");
        }
        if(seatsCode == -1){
            model.addSeats(st);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        int keyCode = (int) arg;
        if(keyCode == -1){
            view.SeatsSuccess("Seats ordered!");
        }else if(keyCode == 1){
            Log.e("firebase", "failed to put data on realtime database");
        }
    }
}
