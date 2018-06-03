package com.draz.amjad.amjadapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LOGIN extends AppCompatActivity implements View.OnClickListener{
    private EditText etEmail;
    private EditText etPass;
    private Button btnSignin;
    private Button btnSignup;
    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener AuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnSignin = (Button) findViewById(R.id.btnSignin);
        btnSignup = (Button) findViewById(R.id.btnSignup);
        etEmail= (EditText) findViewById(R.id.etEmail);
        etPass = (EditText) findViewById(R.id.etPass);
        auth = FirebaseAuth.getInstance();
        btnSignin.setOnClickListener(this);
        btnSignup.setOnClickListener(this);


    }
    private void signIn(String email, String passw) {
        auth.signInWithEmailAndPassword(email, passw).addOnCompleteListener(LOGIN.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(LOGIN.this, "signIn Successful.", Toast.LENGTH_SHORT).show();
                    try {
                        Intent intent = new Intent(LOGIN.this, MainActivity.class);
                        startActivity(intent);
                    }catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    finish();
                } else {
                    Toast.makeText(LOGIN.this, "signIn failed." + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }
            }
        });
    }

    private void dataHandler() {
        String stEmail = etEmail.getText().toString();
        String stPass = etPass.getText().toString();
        boolean isOk=true;
        signIn(stEmail, stPass);

    }


    @Override
    public void onClick(View v) {
        if(v==btnSignup){
            Intent i = new Intent(this,SignUp.class);
            startActivity(i);
        }

        if(v==btnSignin)
        {
            dataHandler();
        }

    }
}
