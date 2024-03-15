package com.example.codefest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button Login;
    private Button Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Login = findViewById(R.id.LoginButton);
        Register = findViewById(R.id.RegisterButton);
    }

    public void LoginBtn(View v){
        startActivity(new Intent(this, Login.class));
    }

    public void RegisBtn(View v){
        startActivity(new Intent(this, Register.class));
    }

    public void AdminBtn(View v){

    }






}