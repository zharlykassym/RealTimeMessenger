package com.tamerlan.realtimemessenger.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.tamerlan.realtimemessenger.R;

public class RegistrationActivity extends AppCompatActivity {

    private EditText editTextTextEmailAddress;
    private EditText editTextTextPassword;
    private Button buttonSignUp;
    private Button buttonForgotPassword;
    private Button buttonRegister;
    private String email;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        initView();

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, RegistrationActivity.class);
    }

    private void initView() {
        editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);
        editTextTextPassword = findViewById(R.id.editTextTextPassword);
        buttonSignUp = findViewById(R.id.buttonSignUp);
        buttonForgotPassword = findViewById(R.id.buttonForgotPassword);
        buttonRegister = findViewById(R.id.buttonRegister);
    }
}