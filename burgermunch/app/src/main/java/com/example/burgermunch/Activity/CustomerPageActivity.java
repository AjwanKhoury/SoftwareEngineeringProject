package com.example.burgermunch.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.burgermunch.Adapter.SeatsAdapter;
import com.example.burgermunch.Object.Customer;
import com.example.burgermunch.Object.ICustomer;
import com.example.burgermunch.Object.Seats;
import com.example.burgermunch.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Comparator;

public class CustomerPageActivity extends AppCompatActivity {
    private TextView logOutBtn,nametxt,phoneNum,points;
    private RecyclerView rvOrderList;
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
        firebaseAuth = FirebaseAuth.getInstance();

        String key = firebaseAuth.getCurrentUser().getUid();
        db.getReference("Customer").child(key).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ICustomer user = snapshot.getValue(Customer.class);
                nametxt.setText(user.getFullName());
                phoneNum.setText(user.getPhoneNumber());
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
    
//        recycleViewLastOrders();
    }

//    private void recycleViewLastOrders() {
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//        recyclerViewSeatsList = findViewById(R.id.seatsView);
//        recyclerViewSeatsList.setLayoutManager(linearLayoutManager);
//        ArrayList<Seats> seatslist = new ArrayList<>();
//        this.databaseReference = db.getReference();
//        databaseReference.child("Seats").addValueEventListener(new ValueEventListener() {
//            @RequiresApi(api = Build.VERSION_CODES.O)
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                seatslist.clear();
//                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                    Seats seat = snapshot.getValue(Seats.class);
//                    seatslist.add(0,seat);
//                }
//                //compare seats object by time.
//                Comparator<Seats> comp = (o1, o2) -> {
//                    String a = o1.getTime();
//                    String b = o2.getTime();
//                    if(a.length()<b.length()) return -1;
//                    if(b.length()<a.length()) return 1;
//                    return a.compareTo(b);
//                };
//                seatslist.sort(comp);
//                adapter = new SeatsAdapter(seatslist);
//                recyclerViewSeatsList.setAdapter(adapter);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {}
//        });
//
//    }
}