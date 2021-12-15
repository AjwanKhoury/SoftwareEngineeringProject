package com.example.burgermunch.Activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.burgermunch.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button FacebookBtn=findViewById(R.id.FacebookBtn);
        Button GoogleBtn=findViewById(R.id.GoogleBtn);
        ImageView logicBtn=findViewById(R.id.logicBtn);
        TextView register_txt=findViewById(R.id.register_txt);



    }
}