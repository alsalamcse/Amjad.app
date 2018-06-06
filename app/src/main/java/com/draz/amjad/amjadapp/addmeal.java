package com.draz.amjad.amjadapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.draz.amjad.amjadapp.data.Proudct;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class addmeal extends AppCompatActivity implements View.OnClickListener{
    private EditText etDrink;
    private EditText etMM;
    private EditText etSM;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meal);
        etMM=(EditText)findViewById(R.id.etMM);
        etDrink=(EditText)findViewById(R.id.etDrink);
        btnSave=(Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataHandler();
            }
        });
    }

    public void dataHandler(){
        //1. get data from the fields
        String stMM=etMM.getText().toString();
        String stSM=etSM.getText().toString();
        String stDrink=etDrink.getText().toString();
        //2. todo vaildate fields input
        //isok=true;...
        //3. data manipulation
        double amount=Double.parseDouble(stDrink);
        double price=Double.parseDouble(stDrink);
        // 4. building data objext
        Proudct p=new Proudct();
        p.setMainMeal(stMM);
        p.setDrinks(stDrink);
        p.setCompleted(false);
        p.setSecondMeal(stSM);


        //5. to get user email ... user info
        FirebaseAuth auth=FirebaseAuth.getInstance();
        FirebaseUser user=auth.getCurrentUser();
        String email=user.getEmail();
        email=email.replace('.','*');

        //6. building data reference
        DatabaseReference reference;
        //todo לקבל קישור למסך הניתונים שלנו
        //// todo קישור הינו לשורש של המסך הניתונים
        reference= FirebaseDatabase.getInstance().getReference();
        reference.child(email).child("mylist").push().setValue(p).addOnCompleteListener(this, new OnCompleteListener<Void>()
        {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful())
                {
                    Toast.makeText(addmeal.this, "Add Proudct Successful",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(addmeal.this, "Add Proudct Failed",Toast.LENGTH_LONG ).show();
                }
            }
        });
        // todo Testing
        // reference.child("list").setValue(stname);
    }

    public void onClick(View view)
    {
        if(btnSave==view)
        {
            dataHandler();
                   }
    }
}

