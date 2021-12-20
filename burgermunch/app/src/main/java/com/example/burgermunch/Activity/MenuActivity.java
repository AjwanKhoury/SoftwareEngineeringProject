package com.example.burgermunch.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.burgermunch.R;

public class MenuActivity extends AppCompatActivity {

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
                startActivity(new Intent(MenuActivity.this,LoginActivity.class));
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