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
import com.google.firebase.auth.FirebaseUser;

public class SignUp extends AppCompatActivity implements View.OnClickListener {
    private EditText etEmail;
    private EditText etPass;
    private Button btnSave;
    private EditText etName1;
    private EditText etPass2;
    private FirebaseAuth auth;
    private FirebaseUser firebaseUser;
    private FirebaseAuth.AuthStateListener AuthListener;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        btnSave = (Button) findViewById(R.id.btnSave);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etName1=(EditText) findViewById(R.id.etName1);
        etPass2=(EditText) findViewById(R.id.etPass2);
        etPass = (EditText) findViewById(R.id.etPass);
        btnSave.setOnClickListener(this);
        auth = FirebaseAuth.getInstance();
        firebaseUser = auth.getCurrentUser();

    }


    private void dataHandler() {
        String stEmail=etEmail.getText().toString();
        String stName=etName1.getText().toString();
        String stPassw=etPass.getText().toString();
        String stRePassw=etPass2.getText().toString();
        boolean isOk=true;//to check if all feilds are filled correctly
        if(stEmail.length()==0 || stEmail.indexOf('@')<1 )
        {
            etEmail.setError("Wrong Email");
            isOk=false;
        }
        if(stPassw.length()<8 || stPassw.equals(stRePassw)==false)
        {
            etPass.setError("Bad Password");
            isOk=false;
        }
        if(isOk)
            creatAcount(stEmail,stPassw);


    }


    private void creatAcount(String email, String passw) {
        auth.createUserWithEmailAndPassword(email, passw).addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(SignUp.this, "Authentication Successful.", Toast.LENGTH_SHORT).show();
                    finish();

                } else {
                    Toast.makeText(SignUp.this, "Authentication failed." + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }
            }
        });

    }
    public void onClick(View v) {
        if (btnSave == v) {
            dataHandler();
        }
    }


}
