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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.burgermunch.Adapter.OrderAdapter;
import com.example.burgermunch.Adapter.SeatsAdapter;
import com.example.burgermunch.Object.Customer;
import com.example.burgermunch.Object.ICustomer;
import com.example.burgermunch.Object.IOrder;
import com.example.burgermunch.Object.Order;
import com.example.burgermunch.Object.Seats;
import com.example.burgermunch.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Comparator;

@RequiresApi(api = Build.VERSION_CODES.O)
public class CustomerPageActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private TextView logOutBtn,nametxt,phoneNum,points;
    private RecyclerView rvOrderList;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference;
    String cusPhone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_page);
        bottomNavigation();
        getCustomer();
        recycleViewLastOrders();
    }

    private void bottomNavigation() {
        LinearLayout homeBtn=findViewById(R.id.homeBtn);
        LinearLayout cartBtn=findViewById(R.id.cartBtn);
        LinearLayout connectionBtn=findViewById(R.id.connectionBtn);
        LinearLayout menuBtn=findViewById(R.id.menuBtn);
        LinearLayout makeContactBtn=findViewById(R.id.makeContactBtn);
        nametxt = findViewById(R.id.nametxt);
        phoneNum = findViewById(R.id.phonenumtxt);
        points = findViewById(R.id.points);
        logOutBtn = findViewById(R.id.LogOutBtn);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CustomerPageActivity.this,MainActivity.class));
            }
        });

        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CustomerPageActivity.this,CartActivity.class));
            }
        });

        connectionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (firebaseAuth.getCurrentUser() !=null) {
                    String id = firebaseAuth.getCurrentUser().getUid();
                    if(id.equals("xoW2uY8P02ZkOPOwxti1MutMUr23")){
                        startActivity(new Intent(CustomerPageActivity.this,ManagementActivity.class));
                    }
                    else {
                        startActivity(new Intent(CustomerPageActivity.this, CustomerPageActivity.class));
                    }
                }
                else {
                    startActivity(new Intent(CustomerPageActivity.this, LoginActivity.class));
                }
            }
        });

        makeContactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CustomerPageActivity.this, MakeContactActivity.class));

            }
        });

        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CustomerPageActivity.this,MenuActivity.class));
            }
        });

        logOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(CustomerPageActivity.this, MainActivity.class));
            }
        });
    }

    private void getCustomer() {
        firebaseAuth = FirebaseAuth.getInstance();
        String key = firebaseAuth.getCurrentUser().getUid();
        db.getReference("Customer").child(key).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ICustomer user = snapshot.getValue(Customer.class);
                nametxt.setText(user.getFullName());
                phoneNum.setText(user.getPhoneNumber());
                points.setText("סה״כ נקודות שנצברו: "+Integer.toString(user.getPoints()));
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });
    }

    private void recycleViewLastOrders() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rvOrderList = findViewById(R.id.lastOrder);
        rvOrderList.setLayoutManager(linearLayoutManager);
        ArrayList<Order> orderlist = new ArrayList<>();
        this.databaseReference = db.getReference();
        String cusid = firebaseAuth.getCurrentUser().getUid();
        //get the current customer
        databaseReference.child("Customer").child(cusid).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Customer user = dataSnapshot.getValue(Customer.class);
                cusPhone = user.getPhoneNumber();}
            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });

        //get all current customer's orders by comparing phoneNum
        databaseReference.child("Orders").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                orderlist.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Order or = snapshot.getValue(Order.class);
                    if(or.getCusPhone().equals(cusPhone)){
                    orderlist.add(0,or);}
                }
                //compare seats object by date.
                Comparator<Order> comp = (o1, o2) -> {
                    String a = o1.getDate();
                    String b = o2.getDate();
                    if(a.length()<b.length()) return -1;
                    if(b.length()<a.length()) return 1;
                    return a.compareTo(b);
                };
                orderlist.sort(comp);
                adapter = new OrderAdapter(orderlist);
                rvOrderList.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });

    }
}