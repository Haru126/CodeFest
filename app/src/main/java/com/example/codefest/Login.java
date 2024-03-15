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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Login extends AppCompatActivity {


    private FirebaseAuth mAuth;
    private EditText EmailInput;
    private EditText PasswordInput;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        EmailInput = findViewById(R.id.EmailInput);
        PasswordInput = findViewById(R.id.Password);

    }

    public void ConfirmLoginBtn(View v){
        String Email, Pass;
        Email = EmailInput.getText().toString();
        Pass = PasswordInput.getText().toString();

        if(!Email.isEmpty() && !Pass.isEmpty()){
            mAuth.signInWithEmailAndPassword(Email, Pass)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {

                                Log.d("Auth", "signInWithEmail:success");
                                startActivity(new Intent(Login.this, lib.class));
                                Toast.makeText(Login.this, "Authentication Success.",
                                        Toast.LENGTH_SHORT).show();
                            } else {

                                Log.w("Auth", "signInWithEmail:failure", task.getException());
                                Toast.makeText(Login.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        } else {
            Toast.makeText(this, "Email or Password Incorrect", Toast.LENGTH_SHORT).show();
        }

    }
}