package com.example.burgermunch.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.burgermunch.Adapter.CategoryAdapter;
import com.example.burgermunch.Adapter.RecommendedAdapter;
import com.example.burgermunch.Domain.CategoryDomain;
import com.example.burgermunch.Domain.FoodDomain;
import com.example.burgermunch.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private RecyclerView.Adapter adapter,adapter2;
private RecyclerView recyclerViewCategotyList, recyclerViewPopularList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCategoty();
        recyclerViewPopular();
        bottomNavigation();
    }

    private void bottomNavigation() {
        LinearLayout homeBtn=findViewById(R.id.homeBtn);
        LinearLayout cartBtn=findViewById(R.id.cartBtn);
        LinearLayout connectionBtn=findViewById(R.id.connectionBtn);
        LinearLayout menuBtn=findViewById(R.id.menuBtn);
        LinearLayout makeContactBtn=findViewById(R.id.makeContactBtn);
        TextView Seats = findViewById(R.id.order_seats);

        TextView Visitor = findViewById(R.id.Visitor);

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
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
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

    }

    private void recyclerViewPopular() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        linearLayoutManager.setReverseLayout(true);
        recyclerViewPopularList = findViewById(R.id.view2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> foodlist = new ArrayList<>();
        foodlist.add(new FoodDomain("מנת הבית", "home_meal", "220 גרם בשר בקר, אווז מעושן, ריבת בצל, רוטב קארי, עגבנייה, חסה, בצל סגול ומלפפון חמוץ", 55, 5, 7, 600));
        foodlist.add(new FoodDomain("סמל ראשון", "sergeant", "440 גרם בקר, 250 גרם אנטריקוט, אווז מעושן, בית עין, בצל מטוגן, עגבנייה, חסה, בצל סגול ומלפפון חמוץ", 87, 4.8, 8, 1490));
        foodlist.add(new FoodDomain("סמל", "sergent", "250 גרם אנטריקוט, אווז מעושן, חלפיניו, עגבנייה, חסה, בצל סגול ומלפפון חמוץ",  83, 4.6, 7, 1270));

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