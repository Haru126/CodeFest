package com.example.codefest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    functions func = new functions();

    Model user = new Model();
    private EditText confirmPass;
    private EditText passInput;
    private EditText emailInput;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        confirmPass = findViewById(R.id.ConfirmPass);
        passInput = findViewById(R.id.Password);
        emailInput = findViewById(R.id.EmailInput);


    }

    public void ConfirmBtn(View v){
        String passMain = passInput.getText().toString();
        String passConf = confirmPass.getText().toString();
        String email = emailInput.getText().toString();

        if(email.contains("@")){
            if(passMain.equals(passConf) && !passMain.isEmpty()){
                user.setEmail(email);
                user.setPassword(passMain);

                //handle code before exiting
                func.toa(this, "SuccessFully Registered");
                startActivity(new Intent(this, Login.class));


            } else {
                func.toa(this, "Password Does Not Match");
            }
        } else {
            func.toa(this, "Invalid Email");
        }

    }

}