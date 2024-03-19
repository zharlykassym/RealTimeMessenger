package com.tamerlan.realtimemessenger.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.tamerlan.realtimemessenger.R;

public class ResetPasswordActivity extends AppCompatActivity {

    private static final String EXTRA_EMAIL = "email";
    private EditText editTextTextEmailAddress;
    private Button buttonResetPassword;
    private Button buttonCancel;
    private Button buttonSignUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        initView();
        String email = getIntent().getStringExtra(EXTRA_EMAIL);
        editTextTextEmailAddress.setText(email);
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public static Intent newIntent(Context context, String email){
        Intent intent = new Intent(context, ResetPasswordActivity.class);
        intent.putExtra(EXTRA_EMAIL,email);
        return intent;
    }

    private void initView(){
        editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);
        buttonResetPassword = findViewById(R.id.buttonResetPassword);
        buttonCancel = findViewById(R.id.buttonCancel);
        buttonSignUp = findViewById(R.id.buttonSignUp);
    }
}