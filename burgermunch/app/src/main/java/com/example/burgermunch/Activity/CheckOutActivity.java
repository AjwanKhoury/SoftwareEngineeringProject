package com.example.burgermunch.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.burgermunch.Controller.OrderController;
import com.example.burgermunch.Helper.ManagementCart;
import com.example.burgermunch.Interface.IOrderView;
import com.example.burgermunch.R;

import java.util.List;

public class CheckOutActivity extends AppCompatActivity implements IOrderView {
    private ManagementCart managementCart;
    private TextView totalFeeTxt, deliveryTxt, totalTxt, payBtn;
    private EditText phoneNum,creditName,cardNum,textDate,CVV, address;
    private OrderController setOrder;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);
        managementCart = new ManagementCart(this);
        setOrder = new OrderController(this);

        initView();
        calculateCard();
        buttonNavi();
    }

    private void buttonNavi() {
        payBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone =phoneNum.getText().toString();
                String add=  address.getText().toString();
                List OrderDetail = managementCart.getListCart();
                progressBar = findViewById(R.id.progressBar);
                progressBar.setVisibility(View.VISIBLE);
                setOrder.OnOrder(phone,add,OrderDetail);
                startActivity(new Intent(CheckOutActivity.this,MainActivity.class));
                //TODO add shipment cost
                //TODO manager user ang login user page
                //TODO add order date variable
                //TODO screenshots after changes

            }
        });
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
        payBtn = findViewById(R.id.payBtn);
        phoneNum =findViewById(R.id.phoneNum);
        creditName=findViewById(R.id.CreditName);
        cardNum=findViewById(R.id.CardNum);
        textDate=findViewById(R.id.TextDate);
        CVV=findViewById(R.id.CVV);
        address=findViewById(R.id.addres);
    }

    @Override
    public void OrderSuccess(String msg) {
        //TODO order
    }

    @Override
    public void OrderError(String msg) {

    }
}