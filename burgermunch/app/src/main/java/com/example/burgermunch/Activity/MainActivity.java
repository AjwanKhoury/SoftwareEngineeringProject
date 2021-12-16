package com.example.burgermunch.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

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

    }

    private void recyclerViewPopular() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        linearLayoutManager.setReverseLayout(true);
        recyclerViewPopularList = findViewById(R.id.view2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> foodlist = new ArrayList<>();
        foodlist.add(new FoodDomain("Pepperoni pizza", "pizza1", "slices pepperoni ,mozzarella cheese, fresh oregano,  ground black pepper, pizza sauce", 13.0, 5, 20, 1000));
        foodlist.add(new FoodDomain("Chesse Burger", "burger", "beef, Gouda Cheese, Special sauce, Lettuce, tomato ", 15.20, 4, 18, 1500));
        foodlist.add(new FoodDomain("Vagetable pizza", "pizza3", " olive oil, Vegetable oil, pitted Kalamata, cherry tomatoes, fresh oregano, basil", 11.0, 3, 16, 800));

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