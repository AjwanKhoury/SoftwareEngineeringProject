package com.example.burgermunch.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import com.example.burgermunch.Adapter.SeatsAdapter;
import com.example.burgermunch.Object.Seats;
import com.example.burgermunch.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Management extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewSeatsList;
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference;




    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seats_management);
        TextView date = findViewById(R.id.Date);
        String currentDate = java.time.LocalDate.now().toString();
        date.setText(currentDate);
        recyclerViewSeats();

    }

    private void recyclerViewSeats() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true);
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
                    seatslist.add(seat);
                    adapter = new SeatsAdapter(seatslist);
                    recyclerViewSeatsList.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });

    }
}