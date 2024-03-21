package com.tamerlan.realtimemessenger.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;
import com.tamerlan.realtimemessenger.R;
import com.tamerlan.realtimemessenger.viewmodule.RegistrationViewModel;

public class RegistrationActivity extends AppCompatActivity {

    private EditText editTextTextEmailAddress;
    private EditText editTextTextPassword;
    private EditText editTextTextName;
    private EditText editTextTextSurname;
    private EditText editTextTextAge;
    private Button buttonLogin;
    private Button buttonCancel;
    private Button buttonSignUp;

    private RegistrationViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        initView();
        viewModel = new ViewModelProvider(this).get(RegistrationViewModel.class);
        observeViewModel();
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = getTrimmedValue(editTextTextEmailAddress);
                String password = getTrimmedValue(editTextTextPassword);
                String name = getTrimmedValue(editTextTextName);
                String surName = getTrimmedValue(editTextTextSurname);
                int age = Integer.parseInt(getTrimmedValue(editTextTextAge));
                viewModel.signUp(email,password,name,surName,age);
            }
        });

//        buttonForgotPassword.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = ResetPasswordActivity.newIntent(RegistrationActivity.this);
//                startActivity(intent);
//            }
//        });
    }

    private String getTrimmedValue(EditText editText) {
        return editText.getText().toString().trim();
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, RegistrationActivity.class);
    }

    private void observeViewModel(){
        viewModel.getError().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String errorMessage) {
                if (errorMessage !=null){
                    Toast.makeText(RegistrationActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
                }
            }
        });
        viewModel.getUser().observe(this, new Observer<FirebaseUser>() {
            @Override
            public void onChanged(FirebaseUser firebaseUser) {
                if (firebaseUser !=null){
                    Intent intent = UsersActivity.newIntent(RegistrationActivity.this);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void initView() {
        editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);
        editTextTextPassword = findViewById(R.id.editTextTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        buttonCancel = findViewById(R.id.buttonCancel);
        buttonSignUp = findViewById(R.id.buttonSignUp);
        editTextTextName = findViewById(R.id.editTextTextName);
        editTextTextSurname = findViewById(R.id.editTextTextSurname);
        editTextTextAge = findViewById(R.id.editTextTextAge);
    }
}