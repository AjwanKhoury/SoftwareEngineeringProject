package com.example.burgermunch.Activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.burgermunch.R;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        ImageView registerBtn=findViewById(R.id.registerBtn);
        TextView recover_pass_txt=findViewById(R.id.recover_pass_txt);

    }
}