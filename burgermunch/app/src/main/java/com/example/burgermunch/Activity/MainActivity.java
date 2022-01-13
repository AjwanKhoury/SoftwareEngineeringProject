package com.example.burgermunch.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.burgermunch.Adapter.CategoryAdapter;
import com.example.burgermunch.Adapter.RecommendedAdapter;
import com.example.burgermunch.Domain.CategoryDomain;
import com.example.burgermunch.Domain.OrderDetails;
import com.example.burgermunch.Object.Customer;
import com.example.burgermunch.Object.ICustomer;
import com.example.burgermunch.Object.Seats;
import com.example.burgermunch.R;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter,adapter2;
    private RecyclerView recyclerViewCategotyList, recyclerViewPopularList;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase db = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewCategoty();
        recyclerViewPopular();
        bottomNavigation();
    }

    private void bottomNavigation() {
        firebaseAuth = FirebaseAuth.getInstance();
        LinearLayout homeBtn=findViewById(R.id.homeBtn);
        LinearLayout cartBtn=findViewById(R.id.cartBtn);
        LinearLayout connectionBtn=findViewById(R.id.connectionBtn);
        LinearLayout menuBtn=findViewById(R.id.menuBtn);
        LinearLayout makeContactBtn=findViewById(R.id.makeContactBtn);
        TextView Seats = findViewById(R.id.order_seats);
        Button managment = findViewById(R.id.Managment);
        TextView Visitor = findViewById(R.id.Visitor);

        managment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ManagementActivity.class));
            }
        });

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,MainActivity.class));
            }
        });

        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,CartActivity.class));
            }
        });

        connectionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (firebaseAuth.getCurrentUser() !=null) {
                    if(firebaseAuth.getCurrentUser().getEmail() == "lishaimelameds@gmail.com"){
                        startActivity(new Intent(MainActivity.this,ManagementActivity.class));
                    }
                    else {
                        startActivity(new Intent(MainActivity.this, CustomerPageActivity.class));
                    }
                }
                else {
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                }
            }
        });

        makeContactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MakeContactActivity.class));

            }
        });

        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,MenuActivity.class));
            }
        });
        Seats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SeatsActivity.class));
            }
        });
        if (firebaseAuth.getCurrentUser() !=null) {
            String key = firebaseAuth.getCurrentUser().getUid();
            db.getReference("Customer").child(key).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    ICustomer user = snapshot.getValue(Customer.class);
                    Visitor.setText(user.getFullName()+" היי ");
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {}
            });
        }
    }

    private void recyclerViewPopular() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        linearLayoutManager.setReverseLayout(true);
        recyclerViewPopularList = findViewById(R.id.view2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<OrderDetails> foodlist = new ArrayList<>();
        foodlist.add(new OrderDetails("מנת הבית", "home_meal1", "220 גרם בשר בקר, אווז מעושן, ריבת בצל ורוטב קארי", 55, 5, 7, 600));
        foodlist.add(new OrderDetails("סמל ראשון", "sergeant", "440 גרם בקר, 250 גרם אנטריקוט, אווז מעושן, ביצת עין ובצל מטוגן", 87, 4.8, 8, 1490));
        foodlist.add(new OrderDetails("סמל", "sergent", "250 גרם אנטריקוט, אווז מעושן וחלפיניו",  83, 4.6, 7, 1270));

        adapter2 = new RecommendedAdapter(foodlist);
        recyclerViewPopularList.setAdapter(adapter2);
    }


    private void recyclerViewCategoty() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        linearLayoutManager.setReverseLayout(true);
        recyclerViewCategotyList = findViewById(R.id.view1);
        recyclerViewCategotyList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> categoryList = new ArrayList<>();
        categoryList.add(new CategoryDomain("מנות היכרות", "cat_11"));
        categoryList.add(new CategoryDomain("מיוחדים", "cat_12"));
        categoryList.add(new CategoryDomain("טורטיות", "cat_13"));
        categoryList.add(new CategoryDomain("מטוגנים", "cat_14"));
        categoryList.add(new CategoryDomain("שתייה", "cat_15"));

        adapter= new CategoryAdapter(categoryList);
        recyclerViewCategotyList.setAdapter(adapter);
    }
}