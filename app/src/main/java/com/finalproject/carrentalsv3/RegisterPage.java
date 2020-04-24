package com.finalproject.carrentalsv3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        EditText firstname=(EditText)findViewById(R.id.Firstname);
        EditText lastname=(EditText)findViewById(R.id.Lastname);
        EditText email=(EditText)findViewById(R.id.Remail);
        EditText password=(EditText)findViewById(R.id.Rpassword);
        EditText mobile=(EditText)findViewById(R.id.Mobile);
        Button register=(Button)findViewById(R.id.Register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(RegisterPage.this,LoginPage.class);
                startActivity(i);
            }
        });
    }
}
