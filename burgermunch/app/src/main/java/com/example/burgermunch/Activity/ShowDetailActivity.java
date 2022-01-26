package com.example.burgermunch.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.burgermunch.Controller.OrderController;
import com.example.burgermunch.Domain.OrderDetails;
import com.example.burgermunch.Helper.ManagementCart;
import com.example.burgermunch.View.IOrderView;
import com.example.burgermunch.R;

public class ShowDetailActivity extends AppCompatActivity implements IOrderView {
    private TextView addToCartBtn,textView;
    private TextView titleTxt, feeTxt, descriptionTxt, totalPriceTxt, starTxt, caloryTxt, timeTxt;
    private ImageView picFood;
    private OrderDetails object;
    private int numberOrder = 1;
    private ManagementCart managementCart;
    private CheckBox tomato,lettuce,onion,pickle,pepper,friedOnion, friedEgg,mushroom,onionJelly,chickenBrest,DoubleChicken,mr,m,mw,wd;
    private IOrderView iorder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);

        managementCart = new ManagementCart(this);

        iniView();
        getBundle();
        Checked();
    }

    private void Checked() {
        object = (OrderDetails) getIntent().getSerializableExtra("object");
        tomato=findViewById(R.id.tomato);
        lettuce=findViewById(R.id.lettuce);
        onion=findViewById(R.id.onion);
        pickle=findViewById(R.id.piccle);
        pepper=findViewById(R.id.pepper);
        friedOnion=findViewById(R.id.friedOnion);
        friedEgg =findViewById(R.id.friedAgg);
        mushroom=findViewById(R.id.mushroom);
        onionJelly=findViewById(R.id.onionJelly);
        chickenBrest=findViewById(R.id.chickenBreast);
        DoubleChicken=findViewById(R.id.doubleChicken);

        if(object.getDescription().contains("חלפיניו")) pepper.setVisibility(View.GONE);
        if(object.getDescription().contains("בצל מטוגן")) friedOnion.setVisibility(View.GONE);
        if(object.getDescription().contains("ביצת עין")) friedEgg.setVisibility(View.GONE);
        if(object.getDescription().contains("פטריות")) mushroom.setVisibility(View.GONE);
        if(object.getDescription().contains("ריבת בצל")) onionJelly.setVisibility(View.GONE);
        if(object.getDescription().contains("אווז מעושן")) chickenBrest.setVisibility(View.GONE);
        if(object.getDescription().contains("דאבל חזה אווז מעושן")) DoubleChicken.setVisibility(View.GONE);

        if(object.getTitle().contains("מים")){
            tomato.setVisibility(View.GONE);
            lettuce.setVisibility(View.GONE);
            onion.setVisibility(View.GONE);
            pickle.setVisibility(View.GONE);
            pepper.setVisibility(View.GONE);
            friedOnion.setVisibility(View.GONE);
            friedEgg.setVisibility(View.GONE);
            mushroom.setVisibility(View.GONE);
            onionJelly.setVisibility(View.GONE);
            chickenBrest.setVisibility(View.GONE);
            DoubleChicken.setVisibility(View.GONE);
            mr.setVisibility(View.GONE);
            m.setVisibility(View.GONE);
            mw.setVisibility(View.GONE);
            wd.setVisibility(View.GONE);
            textView.setVisibility(View.GONE);
        }
        if(object.getTitle().contains("סודה")){
            tomato.setVisibility(View.GONE);
            lettuce.setVisibility(View.GONE);
            onion.setVisibility(View.GONE);
            pickle.setVisibility(View.GONE);
            pepper.setVisibility(View.GONE);
            friedOnion.setVisibility(View.GONE);
            friedEgg.setVisibility(View.GONE);
            mushroom.setVisibility(View.GONE);
            onionJelly.setVisibility(View.GONE);
            chickenBrest.setVisibility(View.GONE);
            DoubleChicken.setVisibility(View.GONE);
            mr.setVisibility(View.GONE);
            m.setVisibility(View.GONE);
            mw.setVisibility(View.GONE);
            wd.setVisibility(View.GONE);
            textView.setVisibility(View.GONE);

        }
        if(object.getTitle().contains("קוקה-קולה")){
            tomato.setVisibility(View.GONE);
            lettuce.setVisibility(View.GONE);
            onion.setVisibility(View.GONE);
            pickle.setVisibility(View.GONE);
            pepper.setVisibility(View.GONE);
            friedOnion.setVisibility(View.GONE);
            friedEgg.setVisibility(View.GONE);
            mushroom.setVisibility(View.GONE);
            onionJelly.setVisibility(View.GONE);
            chickenBrest.setVisibility(View.GONE);
            DoubleChicken.setVisibility(View.GONE);
            mr.setVisibility(View.GONE);
            m.setVisibility(View.GONE);
            mw.setVisibility(View.GONE);
            wd.setVisibility(View.GONE);
            textView.setVisibility(View.GONE);

        }
        if(object.getTitle().contains("קולה-זירו")){
            tomato.setVisibility(View.GONE);
            lettuce.setVisibility(View.GONE);
            onion.setVisibility(View.GONE);
            pickle.setVisibility(View.GONE);
            pepper.setVisibility(View.GONE);
            friedOnion.setVisibility(View.GONE);
            friedEgg.setVisibility(View.GONE);
            mushroom.setVisibility(View.GONE);
            onionJelly.setVisibility(View.GONE);
            chickenBrest.setVisibility(View.GONE);
            DoubleChicken.setVisibility(View.GONE);
            mr.setVisibility(View.GONE);
            m.setVisibility(View.GONE);
            mw.setVisibility(View.GONE);
            wd.setVisibility(View.GONE);
            textView.setVisibility(View.GONE);

        }
        if(object.getTitle().contains("ענבים")){
            tomato.setVisibility(View.GONE);
            lettuce.setVisibility(View.GONE);
            onion.setVisibility(View.GONE);
            pickle.setVisibility(View.GONE);
            pepper.setVisibility(View.GONE);
            friedOnion.setVisibility(View.GONE);
            friedEgg.setVisibility(View.GONE);
            mushroom.setVisibility(View.GONE);
            onionJelly.setVisibility(View.GONE);
            chickenBrest.setVisibility(View.GONE);
            DoubleChicken.setVisibility(View.GONE);
            mr.setVisibility(View.GONE);
            m.setVisibility(View.GONE);
            mw.setVisibility(View.GONE);
            wd.setVisibility(View.GONE);
            textView.setVisibility(View.GONE);

        }
        if(object.getTitle().contains("פיוזטי")){
            tomato.setVisibility(View.GONE);
            lettuce.setVisibility(View.GONE);
            onion.setVisibility(View.GONE);
            pickle.setVisibility(View.GONE);
            pepper.setVisibility(View.GONE);
            friedOnion.setVisibility(View.GONE);
            friedEgg.setVisibility(View.GONE);
            mushroom.setVisibility(View.GONE);
            onionJelly.setVisibility(View.GONE);
            chickenBrest.setVisibility(View.GONE);
            DoubleChicken.setVisibility(View.GONE);
            mr.setVisibility(View.GONE);
            m.setVisibility(View.GONE);
            mw.setVisibility(View.GONE);
            wd.setVisibility(View.GONE);
            textView.setVisibility(View.GONE);

        }
        if(object.getTitle().contains("ציפס בטטה")){
            tomato.setVisibility(View.GONE);
            lettuce.setVisibility(View.GONE);
            onion.setVisibility(View.GONE);
            pickle.setVisibility(View.GONE);
            pepper.setVisibility(View.GONE);
            friedOnion.setVisibility(View.GONE);
            friedEgg.setVisibility(View.GONE);
            mushroom.setVisibility(View.GONE);
            onionJelly.setVisibility(View.GONE);
            chickenBrest.setVisibility(View.GONE);
            DoubleChicken.setVisibility(View.GONE);
            mr.setVisibility(View.GONE);
            m.setVisibility(View.GONE);
            mw.setVisibility(View.GONE);
            wd.setVisibility(View.GONE);
            textView.setVisibility(View.GONE);

        }
        if(object.getTitle().contains("שניצלונים")){
            tomato.setVisibility(View.GONE);
            lettuce.setVisibility(View.GONE);
            onion.setVisibility(View.GONE);
            pickle.setVisibility(View.GONE);
            pepper.setVisibility(View.GONE);
            friedOnion.setVisibility(View.GONE);
            friedEgg.setVisibility(View.GONE);
            mushroom.setVisibility(View.GONE);
            onionJelly.setVisibility(View.GONE);
            chickenBrest.setVisibility(View.GONE);
            DoubleChicken.setVisibility(View.GONE);
            mr.setVisibility(View.GONE);
            m.setVisibility(View.GONE);
            mw.setVisibility(View.GONE);
            wd.setVisibility(View.GONE);
            textView.setVisibility(View.GONE);

        }
        if(object.getTitle().contains("שניצלונים וציפס")){
            tomato.setVisibility(View.GONE);
            lettuce.setVisibility(View.GONE);
            onion.setVisibility(View.GONE);
            pickle.setVisibility(View.GONE);
            pepper.setVisibility(View.GONE);
            friedOnion.setVisibility(View.GONE);
            friedEgg.setVisibility(View.GONE);
            mushroom.setVisibility(View.GONE);
            onionJelly.setVisibility(View.GONE);
            chickenBrest.setVisibility(View.GONE);
            DoubleChicken.setVisibility(View.GONE);
            mr.setVisibility(View.GONE);
            m.setVisibility(View.GONE);
            mw.setVisibility(View.GONE);
            wd.setVisibility(View.GONE);
            textView.setVisibility(View.GONE);

        }
        if(object.getTitle().contains("מיקס מטוגנים")){
            tomato.setVisibility(View.GONE);
            lettuce.setVisibility(View.GONE);
            onion.setVisibility(View.GONE);
            pickle.setVisibility(View.GONE);
            pepper.setVisibility(View.GONE);
            friedOnion.setVisibility(View.GONE);
            friedEgg.setVisibility(View.GONE);
            mushroom.setVisibility(View.GONE);
            onionJelly.setVisibility(View.GONE);
            chickenBrest.setVisibility(View.GONE);
            DoubleChicken.setVisibility(View.GONE);
            mr.setVisibility(View.GONE);
            m.setVisibility(View.GONE);
            mw.setVisibility(View.GONE);
            wd.setVisibility(View.GONE);
            textView.setVisibility(View.GONE);

        }
        if(object.getTitle().contains("טבעות בצל")){
            tomato.setVisibility(View.GONE);
            lettuce.setVisibility(View.GONE);
            onion.setVisibility(View.GONE);
            pickle.setVisibility(View.GONE);
            pepper.setVisibility(View.GONE);
            friedOnion.setVisibility(View.GONE);
            friedEgg.setVisibility(View.GONE);
            mushroom.setVisibility(View.GONE);
            onionJelly.setVisibility(View.GONE);
            chickenBrest.setVisibility(View.GONE);
            DoubleChicken.setVisibility(View.GONE);
            mr.setVisibility(View.GONE);
            m.setVisibility(View.GONE);
            mw.setVisibility(View.GONE);
            wd.setVisibility(View.GONE);
            textView.setVisibility(View.GONE);

        }
        if(object.getTitle().contains("ציפס")){
            tomato.setVisibility(View.GONE);
            lettuce.setVisibility(View.GONE);
            onion.setVisibility(View.GONE);
            pickle.setVisibility(View.GONE);
            pepper.setVisibility(View.GONE);
            friedOnion.setVisibility(View.GONE);
            friedEgg.setVisibility(View.GONE);
            mushroom.setVisibility(View.GONE);
            onionJelly.setVisibility(View.GONE);
            chickenBrest.setVisibility(View.GONE);
            DoubleChicken.setVisibility(View.GONE);
            mr.setVisibility(View.GONE);
            m.setVisibility(View.GONE);
            mw.setVisibility(View.GONE);
            wd.setVisibility(View.GONE);
            textView.setVisibility(View.GONE);

        }
        if(object.getTitle().contains("טורטייה צימחונית")){
            chickenBrest.setVisibility(View.GONE);
            DoubleChicken.setVisibility(View.GONE);
            mr.setVisibility(View.GONE);
            m.setVisibility(View.GONE);
            mw.setVisibility(View.GONE);
            wd.setVisibility(View.GONE);
            textView.setVisibility(View.GONE);
        }

        tomato.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (tomato.isChecked() && !object.getDescription().contains("עגבנייה")) object.setDescription(object.getDescription()+",עגבנייה ");
                else {
                    String temp = object.getDescription().replace(",עגבנייה ", "");
                    object.setDescription(temp);
                }
            }
        });
        lettuce.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (lettuce.isChecked() && !object.getDescription().contains("חסה")) object.setDescription(object.getDescription()+",חסה ");
                else {
                    String temp = object.getDescription().replace(",חסה ", "");
                    object.setDescription(temp);
                }
            }
        });
        onion.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (onion.isChecked() && !object.getDescription().contains("בצל סגול")) object.setDescription(object.getDescription()+",בצל סגול ");
                else {
                    String temp = object.getDescription().replace(",בצל סגול ", "");
                    object.setDescription(temp);
                }
            }
        });
        pickle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (pickle.isChecked() && !object.getDescription().contains("מלפפון חמוץ")) object.setDescription(object.getDescription()+",מלפפון חמוץ ");
                else {
                    String temp = object.getDescription().replace(",מלפפון חמוץ ", "");
                    object.setDescription(temp);
                }
            }
        });
        pepper.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (pepper.isChecked() && !object.getDescription().contains("חלפיניו")){
                    object.setDescription(object.getDescription()+",חלפיניו ");
                    object.setFee(object.getFee()+6);
                    totalPriceTxt.setText(Math.round(numberOrder * object.getFee())+" ש״ח");

                }
                else {
                    String temp = object.getDescription().replace(",חלפיניו ", "");
                    object.setDescription(temp);
                    object.setFee(object.getFee()-6);
                    totalPriceTxt.setText(Math.round(numberOrder * object.getFee())+" ש״ח");
                }
            }
        });
        friedOnion.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (friedOnion.isChecked() && !object.getDescription().contains("בצל מטוגן")){
                    object.setDescription(object.getDescription()+",בצל מטוגן ");
                    object.setFee(object.getFee()+6);
                    totalPriceTxt.setText(Math.round(numberOrder * object.getFee())+" ש״ח");

                }
                else {
                    String temp = object.getDescription().replace(",בצל מטוגן ", "");
                    object.setDescription(temp);
                    object.setFee(object.getFee()-6);
                    totalPriceTxt.setText(Math.round(numberOrder * object.getFee())+" ש״ח");

                }
            }
        });
        friedEgg.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (friedEgg.isChecked() && !object.getDescription().contains("ביצת עין")){
                    object.setDescription(object.getDescription()+",ביצת עין ");
                    object.setFee(object.getFee()+7);
                    totalPriceTxt.setText(Math.round(numberOrder * object.getFee())+" ש״ח");

                }
                else {
                    String temp = object.getDescription().replace(",ביצת עין ", "");
                    object.setDescription(temp);
                    object.setFee(object.getFee()-7);
                    totalPriceTxt.setText(Math.round(numberOrder * object.getFee())+" ש״ח");

                }
            }
        });
        mushroom.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (mushroom.isChecked() && !object.getDescription().contains("פטריות")){
                    object.setDescription(object.getDescription()+",פטריות ");
                    object.setFee(object.getFee()+7);
                    totalPriceTxt.setText(Math.round(numberOrder * object.getFee())+" ש״ח");

                }
                else {
                    String temp = object.getDescription().replace(",פטריות ", "");
                    object.setDescription(temp);
                    object.setFee(object.getFee()-7);
                    totalPriceTxt.setText(Math.round(numberOrder * object.getFee())+" ש״ח");

                }
            }
        });
        onionJelly.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (onionJelly.isChecked() && !object.getDescription().contains("ריבת בצל")){
                    object.setDescription(object.getDescription()+",ריבת בצל ");
                    object.setFee(object.getFee()+9);
                    totalPriceTxt.setText(Math.round(numberOrder * object.getFee())+" ש״ח");

                }
                else {
                    String temp = object.getDescription().replace(",ריבת בצל ", "");
                    object.setDescription(temp);
                    object.setFee(object.getFee()-9);
                    totalPriceTxt.setText(Math.round(numberOrder * object.getFee())+" ש״ח");


                }
            }
        });
        chickenBrest.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (chickenBrest.isChecked() && !object.getDescription().contains("חזה אווז מעושן")){
                    object.setDescription(object.getDescription()+",חזה אווז מעושן ");
                    object.setFee(object.getFee()+13);
                    totalPriceTxt.setText(Math.round(numberOrder * object.getFee())+" ש״ח");

                }
                else {
                    String temp = object.getDescription().replace(",חזה אווז מעושן ", "");
                    object.setDescription(temp);
                    object.setFee(object.getFee()-13);
                    totalPriceTxt.setText(Math.round(numberOrder * object.getFee())+" ש״ח");

                }
            }
        });
        DoubleChicken.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (DoubleChicken.isChecked() && !object.getDescription().contains("דאבל חזה אווז מעושן")){
                    object.setDescription(object.getDescription()+",דאבל חזה אווז מעושן ");
                    object.setFee(object.getFee()+23);
                    totalPriceTxt.setText(Math.round(numberOrder * object.getFee())+" ש״ח");

                }
                else {
                    String temp = object.getDescription().replace(",דאבל חזה אווז מעושן ", "");
                    object.setDescription(temp);
                    object.setFee(object.getFee()-23);
                    totalPriceTxt.setText(Math.round(numberOrder * object.getFee())+" ש״ח");

                }
            }
        });
        mr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (mr.isChecked() && !object.getDescription().contains(",MR")) {
                    object.setDescription(object.getDescription() + ",MR ");
                }
                else {
                    String temp = object.getDescription().replace(",MR ", "");
                    object.setDescription(temp);
                }
            }
        });
        m.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (m.isChecked() && !object.getDescription().contains(",M")) {
                    object.setDescription(object.getDescription() + ",M ");
                }
                else {
                    String temp = object.getDescription().replace(",M ", "");
                    object.setDescription(temp);
                }
            }
        });
        mw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (mw.isChecked() && !object.getDescription().contains(",MW")) {
                    object.setDescription(object.getDescription() + ",MW ");
                }
                else {
                    String temp = object.getDescription().replace(",MW ", "");
                    object.setDescription(temp);
                }
            }
        });
        wd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (m.isChecked() && !object.getDescription().contains(",WD")) {
                    object.setDescription(object.getDescription() + ",WD ");
                }
                else {
                    String temp = object.getDescription().replace(",WD ", "");
                    object.setDescription(temp);
                }
            }
        });


    }

    private void getBundle() {
        object = (OrderDetails) getIntent().getSerializableExtra("object");

        int drawableResourceId = this.getResources().getIdentifier(object.getPic(), "drawable", this.getPackageName());
        Glide.with(this)
                .load(drawableResourceId)
                .into(picFood);

        titleTxt.setText(object.getTitle());
        feeTxt.setText(object.getFee()+" ש״ח");
        descriptionTxt.setText(object.getDescription());
        caloryTxt.setText(object.getCalories() + " קלוריות");
        starTxt.setText(object.getStar() + "");
        timeTxt.setText(object.getTime()+ " דקות ");
        totalPriceTxt.setText(Math.round(numberOrder * object.getFee())+" ש״ח");
        object = (OrderDetails) getIntent().getSerializableExtra("object");
        tomato=findViewById(R.id.tomato);
        lettuce=findViewById(R.id.lettuce);
        onion=findViewById(R.id.onion);
        pickle=findViewById(R.id.piccle);
        pepper=findViewById(R.id.pepper);
        friedOnion=findViewById(R.id.friedOnion);
        friedEgg =findViewById(R.id.friedAgg);
        mushroom=findViewById(R.id.mushroom);
        onionJelly=findViewById(R.id.onionJelly);
        chickenBrest=findViewById(R.id.chickenBreast);
        DoubleChicken=findViewById(R.id.doubleChicken);
        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((!object.getTitle().contains("טורטייה צימחונית")&&!object.getTitle().contains("ציפס")&&!object.getTitle().contains("טבעות בצל")&&!object.getTitle().contains("מיקס מטוגנים")&&!object.getTitle().contains("שניצלונים וציפס")&&!object.getTitle().contains("שניצלונים")&&!object.getTitle().contains("ציפס בטטה")&&!object.getTitle().contains("פיוזטי")&&!object.getTitle().contains("ענבים")&&!object.getTitle().contains("קולה-זירו")&&!object.getTitle().contains("קוקה-קולה")&&!object.getTitle().contains("סודה")&&!object.getTitle().contains("מים"))&&(!mr.isChecked()&&!m.isChecked()&&!mw.isChecked()&&!wd.isChecked())){
                    Toast.makeText(ShowDetailActivity.this, "חובה לבחור מידת עשייה", Toast.LENGTH_SHORT).show();
                }
                else if((mr.isChecked()&&m.isChecked())||(mr.isChecked()&&mw.isChecked())||(mr.isChecked()&&wd.isChecked())||(m.isChecked()&&mw.isChecked())||(m.isChecked()&&wd.isChecked())||(mw.isChecked()&&wd.isChecked())){
                    Toast.makeText(ShowDetailActivity.this, "חובה לבחור מידת עשייה אחת", Toast.LENGTH_SHORT).show();
                }
                else {
                    object.setNumberInCart(numberOrder);
                    managementCart.insertFood(object);
                    startActivity(new Intent(ShowDetailActivity.this, MainActivity.class));
                }
            }
        });
    }

    private void iniView() {
        addToCartBtn = findViewById(R.id.addToCartBtn);
        titleTxt = findViewById(R.id.titleTxt);
        feeTxt = findViewById(R.id.priceTxt);
        descriptionTxt = findViewById(R.id.descriptionTxt);
        picFood = findViewById(R.id.foodPic);
        totalPriceTxt = findViewById(R.id.totalPriceTxt);
        starTxt = findViewById(R.id.starTxt);
        caloryTxt = findViewById(R.id.VicaloriesTxt);
        timeTxt = findViewById(R.id.timeTxt);
        mr = findViewById(R.id.MR);
        m = findViewById(R.id.M);
        mw = findViewById(R.id.MW);
        wd = findViewById(R.id.WD);
        textView = findViewById(R.id.textView);


    }

    @Override
    public void OrderSuccess(String msg) {
    }

    @Override
    public void OrderError(String msg) {
        Toast.makeText(ShowDetailActivity.this, msg, Toast.LENGTH_SHORT).show();
    }
}