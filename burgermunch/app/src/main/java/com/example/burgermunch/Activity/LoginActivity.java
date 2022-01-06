package com.example.burgermunch.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.burgermunch.Controller.ILoginController;
import com.example.burgermunch.Controller.LoginController;
import com.example.burgermunch.Interface.ILoginView;
import com.example.burgermunch.Model.ILoginModel;
import com.example.burgermunch.R;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements ILoginView {
    private ILoginController controller;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        fAuth = FirebaseAuth.getInstance();

        LoginButton FacebookBtn=findViewById(R.id.FacebookBtn);
        CallbackManager callbackManager = CallbackManager.Factory.create();
        FacebookBtn.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                String message = ("Logged in Successfully");
                Toast.makeText(LoginActivity.this,message,Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(@NonNull FacebookException e) {

            }
        });

        ImageView loginBtn=findViewById(R.id.loginBtn);
        TextView register_txt=findViewById(R.id.register_txt);
        final EditText email_txt=findViewById(R.id.email_txt);
        final EditText password_txt=findViewById(R.id.password_txt);
        controller=new LoginController(this);


        register_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailS = email_txt.getText().toString();
                String passwordS = password_txt.getText().toString();
                controller.OnLogin(emailS, passwordS);
            }
        });
    }

    @Override
    public void LoginSuc(String message) {
        Toast.makeText(LoginActivity.this,message,Toast.LENGTH_SHORT).show();
        startActivity(new Intent(LoginActivity.this,MainActivity.class));
    }

    @Override
    public void LoginFail(String message) {
        Toast.makeText(LoginActivity.this,message, Toast.LENGTH_SHORT).show();
    }
}