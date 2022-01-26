package com.example.burgermunch.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.burgermunch.R;
import com.google.firebase.auth.FirebaseAuth;

public class MenuActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        bottomNavigation();
    }
    private void bottomNavigation() {
        LinearLayout homeBtn=findViewById(R.id.homeBtn);
        LinearLayout cartBtn=findViewById(R.id.cartBtn);
        LinearLayout connectionBtn=findViewById(R.id.connectionBtn);
        LinearLayout menuBtn=findViewById(R.id.menuBtn);
        LinearLayout makeContactBtn=findViewById(R.id.makeContactBtn);


        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this,MainActivity.class));
            }
        });

        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this,CartActivity.class));
            }
        });

        connectionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (firebaseAuth.getCurrentUser() !=null) {
                    String id = firebaseAuth.getCurrentUser().getUid();
                    if(id.equals("xoW2uY8P02ZkOPOwxti1MutMUr23")){
                        startActivity(new Intent(MenuActivity.this,ManagementActivity.class));
                    }
                    else {
                        startActivity(new Intent( MenuActivity.this, CustomerPageActivity.class));
                    }
                }
                else {
                    startActivity(new Intent(MenuActivity.this, LoginActivity.class));
                }
            }
        });

        makeContactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, MakeContactActivity.class));

            }
        });

        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this,MenuActivity.class));
            }
        });
    }
}