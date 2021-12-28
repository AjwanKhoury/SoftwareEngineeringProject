package com.example.burgermunch.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.burgermunch.Adapter.RecommendedAdapter;
import com.example.burgermunch.Adapter.SeatsAdapter;
import com.example.burgermunch.Domain.OrderDetails;
import com.example.burgermunch.Object.Seats;
import com.example.burgermunch.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Management extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewSeatsList;
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seats_management);
        recyclerViewSeats();

    }

    private void recyclerViewSeats() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true);
        recyclerViewSeatsList = findViewById(R.id.seatsView);
        recyclerViewSeatsList.setLayoutManager(linearLayoutManager);
        ArrayList<Seats> seatslist = new ArrayList<>();
        this.databaseReference = db.getReference();
        databaseReference.child("seats").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Seats seat = snapshot.getValue(Seats.class);
                    updateList(seat , seatslist);
                    adapter = new SeatsAdapter(seatslist);
                    recyclerViewSeatsList.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });
    }
        public void updateList(Seats s , List<Seats> l){
        //check if seat already exist
                for (int i=0; i<l.size(); i++){
                    if (s.getPhoneNumber().equals(l.get(i).getPhoneNumber())){
                        l.remove(i);
                        l.add(0 , s);
                        break;
                    }
                }
        }
}