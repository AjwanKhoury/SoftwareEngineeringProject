package com.example.burgermunch.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.burgermunch.Object.Customer;
import com.example.burgermunch.Object.ICustomer;
import com.example.burgermunch.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CustomerPageActivity extends AppCompatActivity {
    private TextView logOutBtn,nametxt,phoneNum,points;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase db = FirebaseDatabase.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_page);
        nametxt = findViewById(R.id.nametxt);
        phoneNum = findViewById(R.id.phonenumtxt);
        points = findViewById(R.id.points);
        logOutBtn = findViewById(R.id.LogOutBtn);

        String key = firebaseAuth.getCurrentUser().getUid();
        db.getReference("Customer").child(key).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ICustomer user = snapshot.getValue(Customer.class);
                nametxt.setText(user.getFullName());
                phoneNum.setText(user.getPhoneNumber());
                points.setText(user.);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });

        logOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(CustomerPageActivity.this, MainActivity.class));
            }
        });


    }
}