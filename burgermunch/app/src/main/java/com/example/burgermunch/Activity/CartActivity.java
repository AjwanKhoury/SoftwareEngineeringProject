package com.example.burgermunch.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.burgermunch.Adapter.CartListAdapter;
import com.example.burgermunch.Domain.OrderDetails;
import com.example.burgermunch.Helper.ManagementCart;
import com.example.burgermunch.Helper.ChangeNumberItemsListener;
import com.example.burgermunch.R;

import java.util.List;

public class CartActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewList;
    private ManagementCart managementCart;
    private TextView totalFeeTxt, deliveryTxt, totalTxt, emptyTxt,check;
    private ScrollView scrollView;
    private String Da,St,Cus,Or;
    private List<OrderDetails> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        check = findViewById(R.id.check);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CartActivity.this,CheckOutActivity.class));
            }
        });

        managementCart = new ManagementCart(this);

        initView();
        initList();
        bottomNavigation();
        calculateCard();
    }

    private void bottomNavigation() {
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        LinearLayout cartBtn = findViewById(R.id.cartBtn);
        LinearLayout connectionBtn = findViewById(R.id.connectionBtn);
        LinearLayout menuBtn = findViewById(R.id.menuBtn);
        LinearLayout makeContactBtn=findViewById(R.id.makeContactBtn);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CartActivity.this, MainActivity.class));
            }
        });

        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CartActivity.this, CartActivity.class));
            }
        });

        connectionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CartActivity.this,LoginActivity.class));
            }
        });

        makeContactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CartActivity.this, MakeContactActivity.class));

            }
        });

        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CartActivity.this, MenuActivity.class));
            }
        });

    }




    private void initList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewList.setLayoutManager(linearLayoutManager);
        adapter = new CartListAdapter(managementCart.getListCart(), this, new ChangeNumberItemsListener() {
            @Override
            public void changed() {
                calculateCard();
            }
        });

        recyclerViewList.setAdapter(adapter);
        if (managementCart.getListCart().isEmpty()) {
            emptyTxt.setVisibility(View.VISIBLE);
            scrollView.setVisibility(View.GONE);
        } else {
            emptyTxt.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);
        }
    }

    private void calculateCard() {
        double delivery = 10;     //you can change this item you need price for delivery

        double total = Math.round((managementCart.getTotalFee() + delivery) * 100.0) / 100.0;
        double itemTotal = Math.round(managementCart.getTotalFee() * 100.0) / 100.0;

        totalFeeTxt.setText(itemTotal+" ש״ח");
        deliveryTxt.setText(delivery+" ש״ח");
        totalTxt.setText(total+" ש״ח");
    }

    private void initView() {
        totalFeeTxt = findViewById(R.id.totalFeeTxt);
        deliveryTxt = findViewById(R.id.deliveryTxt);
        totalTxt = findViewById(R.id.totalTxt);
        recyclerViewList = findViewById(R.id.view);
        scrollView = findViewById(R.id.scrollView);
        emptyTxt = findViewById(R.id.emptyTxt);
    }

}