package com.finalproject.carrentalsv3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        final EditText emailEt=(EditText)findViewById(R.id.Email);
        final EditText passwordEt=(EditText)findViewById(R.id.Password);
        Button Login=(Button)findViewById(R.id.Login);
        TextView signuphere=(TextView)findViewById(R.id.Signup);


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = emailEt.getText().toString();
                    String Password = passwordEt.getText().toString();

                    if(Email.isEmpty()){
                        emailEt.setError("Email Required");
                        emailEt.requestFocus();
                        return;
                    }
                    if(!Patterns.EMAIL_ADDRESS.matcher(Email).matches()){
                        emailEt.setError("Enter Valid Email");
                        emailEt.requestFocus();
                        return;
                    }
                    if(Password.isEmpty() || Password.length()<6){
                        passwordEt.setError("Incorrect Password");
                        passwordEt.requestFocus();
                        return;
                    }

                    Call<ResponseBody> call = RetrofitClient
                            .getInstance().getApi()
                            .login(Email,Password);
                    call.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            try {
                                String s = response.body().string();
                                Toast.makeText(LoginPage.this,"Login Successfull",Toast.LENGTH_LONG).show();
                                Intent log= new Intent(LoginPage.this,CitySelection.class);
                                startActivity(log);


                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            Toast.makeText(LoginPage.this,"Login Failed",Toast.LENGTH_LONG).show();
                        }
                    });


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
