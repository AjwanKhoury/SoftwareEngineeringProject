package com.example.burgermunch.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.burgermunch.Helper.ManagementCart;
import com.example.burgermunch.R;

public class CheckOutActivity extends AppCompatActivity {
    private ManagementCart managementCart;
    private TextView totalFeeTxt, deliveryTxt, totalTxt, payBtn;
    private EditText phoneNum,creditName,cardNum,textDate,CVV, address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);
        managementCart = new ManagementCart(this);

        initView();
        calculateCard();
        buttonNavi();
    }

    private void buttonNavi() {
        payBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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

}