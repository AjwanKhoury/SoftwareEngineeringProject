package com.example.burgermunch.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.burgermunch.Controller.RegisterController;
import com.example.burgermunch.Interface.IRegisterView;
import com.example.burgermunch.R;


public class RegisterActivity extends AppCompatActivity implements IRegisterView {
    private EditText full_name, phone_number,address, email, password;
    private RegisterController controllerSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        controllerSignUp = new RegisterController(this);

        TextView recover_pass_txt=findViewById(R.id.recover_pass_txt);
        full_name = findViewById(R.id.name_txt);
        address = findViewById(R.id.address_txt);
        phone_number = findViewById(R.id.phoneNum_txt);
        email = findViewById(R.id.email_txt);
        password = findViewById(R.id.password_txt);
    }

    public void Click(View view){
                String f_nameS = full_name.getText().toString();
                String addressS = address.getText().toString();
                String phone_numberS = phone_number.getText().toString();
                String emailS = email.getText().toString();
                String passwordS = password.getText().toString();
                controllerSignUp.OnRegister(f_nameS,addressS,phone_numberS,emailS,passwordS);
        }

    @Override
    public void RegisterSuccess(String message) {
        Toast.makeText(RegisterActivity.this, message, Toast.LENGTH_SHORT).show();
        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
    }

    @Override
    public void RegisterError(String message) {
        Toast.makeText(RegisterActivity.this, message, Toast.LENGTH_SHORT).show();
    }

}