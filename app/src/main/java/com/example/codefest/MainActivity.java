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
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    public void RegisBtn(View v){
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }






}