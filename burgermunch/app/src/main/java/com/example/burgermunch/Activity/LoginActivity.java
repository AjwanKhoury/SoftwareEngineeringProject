package com.example.burgermunch.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
        ImageView loginBtn=findViewById(R.id.loginBtn);
        TextView register_txt=findViewById(R.id.register_txt);
        final EditText email_txt=findViewById(R.id.email_txt);
        final EditText password_txt=findViewById(R.id.password_txt);

        register_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });
    }
}