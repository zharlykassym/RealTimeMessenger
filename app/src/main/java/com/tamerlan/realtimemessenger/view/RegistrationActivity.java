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
    private EditText editTextTextName;
    private EditText editTextTextSurname;
    private EditText editTextTextAge;
    private Button buttonLogin;
    private Button buttonCancel;
    private Button buttonSignUp;
    private String email;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        initView();

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  getTrimmedValue(editTextTextEmailAddress);
                  getTrimmedValue(editTextTextPassword);
                  getTrimmedValue(editTextTextName);
                  getTrimmedValue(editTextTextSurname);
                  int age = Integer.parseInt(getTrimmedValue(editTextTextAge));
                // sign up .createdEmailAddressAndPassword(email, password);
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

    private String getTrimmedValue(EditText editText){
        return editText.getText().toString().trim();
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, RegistrationActivity.class);
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