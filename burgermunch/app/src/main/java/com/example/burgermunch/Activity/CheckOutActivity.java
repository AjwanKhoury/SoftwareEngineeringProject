package com.example.burgermunch.Activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.burgermunch.Controller.OrderController;
import com.example.burgermunch.Helper.ManagementCart;
import com.example.burgermunch.Object.CCinfo;
import com.example.burgermunch.View.IOrderView;
import com.example.burgermunch.R;

import java.util.List;

public class CheckOutActivity extends AppCompatActivity implements IOrderView {
    private ManagementCart managementCart;
    private TextView totalFeeTxt, deliveryTxt, totalTxt, payBtn;
    private EditText phoneNum,creditName,cardNum,textDate,CVV,ID,address;
    private CCinfo creditCard;
    private OrderController setOrder;
    private ProgressBar progressBar;
    private AlertDialog.Builder build;
    private AlertDialog popUpDelivery;
    private ListView deliveryList;
    private int deliveryCost = 0;
    private String[] delivery ={"ישוב תפוח - מינימום 100 ש״ח, משלוח 10 ש״ח", "רחלים - מינימום 120 ש״ח, משלוח 15 ש״ח", "חטמ״ר שומרון - מינימום 150 ש״ח, משלוח 15 ש״ח", "יצהר - מינימום 150 ש״ח, משלוח 15 ש״ח", "מגדלים - מינימום 150 ש״ח, משלוח 15 ש״ח", "מעלה לבונה - מינימום 150 ש״ח, משלוח 20 ש״ח", "עלי - מינימום 150 ש״ח, משלוח 20 ש״ח", "איתמר - מינימום 150 ש״ח, משלוח 20 ש״ח", "הר ברכה - מינימום 150 ש״ח, משלוח 20 ש״ח", "גבעת איתמר - מינימום 350 ש״ח, משלוח 30 ש״ח", "אלון מורה - מינימום 350 ש״ח, משלוח 30 ש״ח", "שילה - מינימום 350 ש״ח, משלוח 30 ש״ח", "נריה  – מינימום 50 ש״ח", "טלמון  – מינימום 50 ש״ח", "בסיס חורש ירון - מינימום 75 ש״ח", "דולב - מינימום 120 ש״ח, משלוח 12 ש״ח", "חורשה - מינימום 120 ש״ח, משלוח 12 ש״ח", "כרם רעים - מינימום 150 ש״ח, משלוח 12 ש״ח", "נעלה - מינימום 150 ש״ח, משלוח 12 ש״ח", "ניל״י - מינימום 150 ש״ח, משלוח 12 ש״ח", "נווה צוף(חלמיש) - מינימום 200 ש״ח, משלוח 12 ש״ח", "עטרת - מינימום 250 ש״ח, משלוח 12 ש״ח", "מוצב נווה יאיר - מינימום 300 ש״ח, משלוח 12 ש״ח", " כל מקום אחר לחץ כאן ליצירת קשר "};


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
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                String phone =phoneNum.getText().toString();
                String add=  address.getText().toString();
                List OrderDetail = managementCart.getListCart();
                progressBar = findViewById(R.id.progressBar);
                creditCard = new CCinfo(creditName.getText().toString(),phone,
                        cardNum.getText().toString(),textDate.getText().toString(),
                        CVV.getText().toString(),"123");
                setOrder.OnOrder(phone,add,OrderDetail,creditCard);
                //TODO manager user ang login user page
                //TODO screenshots after changes
            }
        });
    }


    private void calculateCard() {
        int total = (int) (Math.round((managementCart.getTotalFee() + deliveryCost) * 100) / 100);
        int itemTotal = (int) (Math.round(managementCart.getTotalFee() * 100) / 100);

        totalFeeTxt.setText(itemTotal+" ש״ח");
        deliveryTxt.setText(deliveryCost+" ש״ח");
        totalTxt.setText(total+" ש״ח");
    }

    public void createPopup(View v){
        build = new AlertDialog.Builder(this);
        View popUpView = getLayoutInflater().inflate(R.layout.popup_delivery, null);
        deliveryList = popUpView.findViewById(R.id.delivery);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,delivery);
        deliveryList.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        build.setView(popUpView);
        popUpDelivery = build.create();
        popUpDelivery.show();

        deliveryList.setOnItemClickListener((parent, view, position, id) -> {
            if (delivery[position].equals("ישוב תפוח - מינימום 100 ש״ח, משלוח 10 ש״ח")) {
                deliveryCost = 10;
                calculateCard();
                popUpDelivery.cancel();
            }
            if (delivery[position].equals("רחלים - מינימום 120 ש״ח, משלוח 15 ש״ח")){
                deliveryCost = 15;
                calculateCard();
                popUpDelivery.cancel();
            }
            if (delivery[position].equals("חטמ״ר שומרון - מינימום 150 ש״ח, משלוח 15 ש״ח")) {
                deliveryCost = 15;
                calculateCard();
                popUpDelivery.cancel();
            }
            if (delivery[position].equals("יצהר - מינימום 150 ש״ח, משלוח 15 ש״ח")) {
                deliveryCost = 15;
                calculateCard();
                popUpDelivery.cancel();
            }
            if (delivery[position].equals("מגדלים - מינימום 150 ש״ח, משלוח 15 ש״ח")) {
                deliveryCost = 15;
                calculateCard();
                popUpDelivery.cancel();
            }
            if (delivery[position].equals("מעלה לבונה - מינימום 150 ש״ח, משלוח 20 ש״ח")){
                deliveryCost = 20;
                calculateCard();
                popUpDelivery.cancel();
            }
            if (delivery[position].equals("עלי - מינימום 150 ש״ח, משלוח 20 ש״ח")){
                deliveryCost = 20;
                calculateCard();
                popUpDelivery.cancel();
            }
            if (delivery[position].equals("איתמר - מינימום 150 ש״ח, משלוח 20 ש״ח")){
                deliveryCost = 20;
                calculateCard();
                popUpDelivery.cancel();
            }
            if (delivery[position].equals("הר ברכה - מינימום 150 ש״ח, משלוח 20 ש״ח")){
                deliveryCost = 20;
                calculateCard();
                popUpDelivery.cancel();
            }
            if (delivery[position].equals("גבעת איתמר - מינימום 350 ש״ח, משלוח 30 ש״ח")){
                deliveryCost = 30;
                calculateCard();
                popUpDelivery.cancel();
            }
            if (delivery[position].equals("אלון מורה - מינימום 350 ש״ח, משלוח 30 ש״ח")){
                deliveryCost = 30;
                calculateCard();
                popUpDelivery.cancel();
            }
            if (delivery[position].equals("שילה - מינימום 350 ש״ח, משלוח 30 ש״ח")){
                deliveryCost = 30;
                calculateCard();
                popUpDelivery.cancel();
            }
            if (delivery[position].equals("נריה  – מינימום 50 ש״ח")){
                deliveryCost = 0;
                calculateCard();
                popUpDelivery.cancel();
            }
            if (delivery[position].equals("טלמון  – מינימום 50 ש״ח")){
                deliveryCost = 0;
                calculateCard();
                popUpDelivery.cancel();
            }
            if (delivery[position].equals("בסיס חורש ירון - מינימום 75 ש״ח")){
                deliveryCost = 0;
                calculateCard();
                popUpDelivery.cancel();
            }
            if (delivery[position].equals("דולב - מינימום 120 ש״ח, משלוח 12 ש״ח")){
                deliveryCost = 12;
                calculateCard();
                popUpDelivery.cancel();
            }
            if (delivery[position].equals("חורשה - מינימום 120 ש״ח, משלוח 12 ש״ח")){
                deliveryCost = 12;
                calculateCard();
                popUpDelivery.cancel();
            }
            if (delivery[position].equals("כרם רעים - מינימום 150 ש״ח, משלוח 12 ש״ח")) {
                deliveryCost = 12;
                calculateCard();
                popUpDelivery.cancel();
            }
            if (delivery[position].equals("נעלה - מינימום 150 ש״ח, משלוח 12 ש״ח")) {
                deliveryCost = 12;
                calculateCard();
                popUpDelivery.cancel();
            }
            if (delivery[position].equals("ניל״י - מינימום 150 ש״ח, משלוח 12 ש״ח")) {
                deliveryCost = 12;
                calculateCard();
                popUpDelivery.cancel();
            }
            if (delivery[position].equals("נווה צוף(חלמיש) - מינימום 200 ש״ח, משלוח 12 ש״ח")) {
                deliveryCost = 12;
                calculateCard();
                popUpDelivery.cancel();
            }
            if (delivery[position].equals("עטרת - מינימום 250 ש״ח, משלוח 12 ש״ח")) {
                deliveryCost = 12;
                calculateCard();
                popUpDelivery.cancel();
            }
            if (delivery[position].equals("מוצב נווה יאיר - מינימום 300 ש״ח, משלוח 12 ש״ח")) {
                deliveryCost = 12;
                calculateCard();
                popUpDelivery.cancel();
            }
            if (delivery[position].equals(" כל מקום אחר לחץ כאן ליצירת קשר ")){
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:*2395"));
                startActivity(intent);
            }
        });
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
        //ID=findViewById(R.id.idtxt);
        address=findViewById(R.id.addres);
    }

    @Override
    public void OrderSuccess(String msg) {
        progressBar.setVisibility(View.VISIBLE);
        Toast.makeText(CheckOutActivity.this, msg, Toast.LENGTH_SHORT).show();
        startActivity(new Intent(CheckOutActivity.this,MainActivity.class));
    }

    @Override
    public void OrderError(String msg) {
        Toast.makeText(CheckOutActivity.this, msg, Toast.LENGTH_SHORT).show();
    }
}