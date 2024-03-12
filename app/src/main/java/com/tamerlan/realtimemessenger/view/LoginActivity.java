package com.tamerlan.realtimemessenger.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.tamerlan.realtimemessenger.R;
import com.tamerlan.realtimemessenger.viewmodule.LoginViewModel;

import android.content.Context;


public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";

    private LoginViewModel loginViewModel;


    private EditText editTextTextEmailAddress;
    private EditText editTextTextPassword;
    private Button buttonLogin;
    private Button buttonForgotPassword;
    private Button buttonRegister;
    private String email;
    private String password;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextTextEmailAddress.getText() != null && editTextTextPassword.getText() != null) {
                    email = editTextTextEmailAddress.getText().toString().trim();
                    password = editTextTextPassword.getText().toString().trim();
                }
                loginViewModel.signInWithEmailAddressAndPassword(email, password);
            }
        });
        buttonForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //launch intent to forgot password screen
            }
        });

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = RegistrationActivity.newIntent(LoginActivity.this);
                startActivity(intent);
            }
        });

    }


    private void initView() {
        editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);
        editTextTextPassword = findViewById(R.id.editTextTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        buttonForgotPassword = findViewById(R.id.buttonForgotPassword);
        buttonRegister = findViewById(R.id.buttonRegister);
    }
}