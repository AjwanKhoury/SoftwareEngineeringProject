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

import com.example.burgermunch.Adapter.OrderAdapter;
import com.example.burgermunch.Adapter.OrderAdapterManagement;
import com.example.burgermunch.Adapter.SeatsAdapter;
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
public class ManagementActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter; // seats adapter
    private RecyclerView.Adapter adapter2; // order adapter
    private RecyclerView recyclerViewSeatsList;
    private RecyclerView recyclerViewOrdersList;
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference;
    TextView logOutBtn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management);
        TextView date = findViewById(R.id.Date);
        logOutBtn = findViewById(R.id.LogOutBtn);
        String currentDate = java.time.LocalDate.now().toString();
        date.setText(currentDate);
        recyclerViewSeats();
        recyclerViewOrders();
        logOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(ManagementActivity.this, MainActivity.class));
            }
        });

    }

    private void recyclerViewSeats() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewSeatsList = findViewById(R.id.seatsView);
        recyclerViewSeatsList.setLayoutManager(linearLayoutManager);
        ArrayList<Seats> seatslist = new ArrayList<>();
        this.databaseReference = db.getReference();
        databaseReference.child("Seats").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                seatslist.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Seats seat = snapshot.getValue(Seats.class);
                    seatslist.add(0,seat);
                }
                //compare seats object by time.
                Comparator<Seats> comp = (o1, o2) -> {
                    String a = o1.getTime();
                    String b = o2.getTime();
                    if(a.length()<b.length()) return -1;
                    if(b.length()<a.length()) return 1;
                    return a.compareTo(b);
                };
                seatslist.sort(comp);
                adapter = new SeatsAdapter(seatslist);
                recyclerViewSeatsList.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });

    }
    private void recyclerViewOrders() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewOrdersList = findViewById(R.id.ordersView);
        recyclerViewOrdersList.setLayoutManager(linearLayoutManager);
        ArrayList<Order> orderList = new ArrayList<>();
        this.databaseReference = db.getReference();
        databaseReference.child("Orders").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                orderList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Order or = snapshot.getValue(Order.class);
                    orderList.add(0,or);
                }
                //compare seats object by time.
                Comparator<Order> comp = (o1, o2) -> {
                    String a = o1.getStatus();
                    String b = o2.getStatus();
                    if(a.length()<b.length()) return -1;
                    if(b.length()<a.length()) return 1;
                    return a.compareTo(b);
                };
                orderList.sort(comp);
                adapter2 = new OrderAdapterManagement(orderList);
                recyclerViewOrdersList.setAdapter(adapter2);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });

    }
}