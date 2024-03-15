package com.example.codefest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    Model user = new Model();
    private EditText EmailInput;
    private EditText PasswordInput;

    private String tempEmail;
    private String tempPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EmailInput = findViewById(R.id.EmailInput);
        PasswordInput = findViewById(R.id.PasswordInput);

    }

    public void LogIn(View v){
        String Email, Pass;
        Email = EmailInput.getText().toString();
        Pass = PasswordInput.getText().toString();

        if(Email.equals(user.getEmail()) && Pass.equals(user.getPassword())){
            startActivity(new Intent(this, MainActivity.class));
        } else if(Email.isEmpty()){
            Toast toast = Toast.makeText(this, "Email Cannot be Empty", Toast.LENGTH_SHORT);
            toast.show();
        } else if(Pass.isEmpty()){
            Toast toast = Toast.makeText(this, "Password Cannot be Empty", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            Toast toast = Toast.makeText(this, "Email or Password Incorrect", Toast.LENGTH_SHORT);
            toast.show();
        }

    }
}