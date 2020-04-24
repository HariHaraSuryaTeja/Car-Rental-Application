package com.finalproject.carrentalsv3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        EditText email=(EditText)findViewById(R.id.Email);
        EditText password=(EditText)findViewById(R.id.Password);
        Button Login=(Button)findViewById(R.id.Login);
        TextView signuphere=(TextView)findViewById(R.id.Signup);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent i=new Intent(LoginPage.this,CarSelection.class);
               startActivity(i);
            }
        });
        signuphere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(LoginPage.this,RegisterPage.class);
                startActivity(i);
            }
        });

    }
}
