package com.example.burgermunch.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.burgermunch.R;
import com.google.firebase.auth.FirebaseAuth;

public class CustomerPageActivity extends AppCompatActivity {
    private TextView logOutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_page);
        logOutBtn = findViewById(R.id.LogOutBtn);
        logOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(CustomerPageActivity.this, MainActivity.class));
            }
        });
    }
}