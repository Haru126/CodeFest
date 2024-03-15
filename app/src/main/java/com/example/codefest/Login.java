package com.example.codefest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    private EditText EmailInput;
    private EditText PasswordInput;

    private String tempEmail;
    private String tempPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



    }



}