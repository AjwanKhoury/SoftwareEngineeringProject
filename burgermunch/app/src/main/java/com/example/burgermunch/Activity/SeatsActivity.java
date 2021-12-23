package com.example.burgermunch.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.burgermunch.Controller.RegisterController;
import com.example.burgermunch.Controller.SeatsController;
import com.example.burgermunch.Interface.ISeatsView;
import com.example.burgermunch.R;

public class SeatsActivity extends AppCompatActivity implements ISeatsView {
    EditText seats , fn , phone , time;
    private SeatsController controllerSeats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seats);
        controllerSeats = new SeatsController(this);
        bottomNavigation();
    }

    private void bottomNavigation() {
        LinearLayout homeBtn=findViewById(R.id.homeBtn);
        LinearLayout cartBtn=findViewById(R.id.cartBtn);
        LinearLayout connectionBtn=findViewById(R.id.connectionBtn);
        LinearLayout menuBtn=findViewById(R.id.menuBtn);
        LinearLayout makeContactBtn=findViewById(R.id.makeContactBtn);

         seats = findViewById(R.id.NumSeats);
         fn = findViewById(R.id.fullnameSeats);
         phone = findViewById(R.id.phoneSeats);
         time = findViewById(R.id.hourSeats);


        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SeatsActivity.this,MainActivity.class));
            }
        });

        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SeatsActivity.this,CartActivity.class));
            }
        });

        connectionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SeatsActivity.this,LoginActivity.class));
            }
        });

        makeContactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SeatsActivity.this, MakeContactActivity.class));

            }
        });

        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SeatsActivity.this,MenuActivity.class));
            }
        });

    }
    public void Liroy(View view) {
        String tempSeats = seats.getText().toString();
        int seatsS;
        try {
            seatsS = Integer.parseInt(tempSeats);
        } catch (NumberFormatException e) {
            seatsS=0;
        }
        String fnS = fn.getText().toString();
        String phoneS = phone.getText().toString();
        String timeS = time.getText().toString();
        controllerSeats.OnSeats(seatsS , fnS , phoneS , timeS);
    }

    @Override
    public void SeatsSuccess(String msg) {
        Toast.makeText(SeatsActivity.this, msg, Toast.LENGTH_SHORT).show();
        startActivity(new Intent(SeatsActivity.this, MainActivity.class));
    }

    @Override
    public void SeatsError(String msg) {
        Toast.makeText(SeatsActivity.this, msg, Toast.LENGTH_SHORT).show();
    }


}