package com.example.codefest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity {

    private FirebaseAuth mAuth;
    functions func = new functions();
    private EditText confirmPass;
    private EditText passInput;
    private EditText emailInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();
        confirmPass = findViewById(R.id.RetypePassword);
        passInput = findViewById(R.id.Password);
        emailInput = findViewById(R.id.EmailInput);


    }
    public void ConfirmRegisterBtn(View v) {
        String passMain = passInput.getText().toString();
        String passConf = confirmPass.getText().toString();
        String email = emailInput.getText().toString();

        if(passMain.equals(passConf) && !passMain.isEmpty()){
            mAuth.createUserWithEmailAndPassword(email, passMain)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {

                                Log.d("Auth", "createUserWithEmail:success");
                                startActivity(new Intent(Register.this, Login.class));
                            } else {

                                Log.w("Auth", "createUserWithEmail:failure", task.getException());
                                func.toa(Register.this, "Registration failed.");
                            }
                        }
                    });
        } else if(passMain.isEmpty() && passConf.isEmpty() && email.isEmpty()){
            func.toa(Register.this, "Don't leave prompts empty");
        }
        else {
            func.toa(Register.this, "Password doesn't match.");
        }
    }


}