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

public class RegisterPage extends AppCompatActivity {

    EditText firstname,lastname,email,password,mobile;
    Button register;
    TextView tvlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        firstname=findViewById(R.id.Firstname);
        lastname=findViewById(R.id.Lastname);
        email=findViewById(R.id.Remail);
        password=findViewById(R.id.Rpassword);
        mobile=findViewById(R.id.Mobile);
        register=findViewById(R.id.Register);
        tvlogin=findViewById(R.id.LoginTv);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        String FirstName = firstname.getText().toString();
        String LastName = lastname.getText().toString();
        String Email = email.getText().toString();
        String Password = password.getText().toString();
        String Mobile = mobile.getText().toString();

        if(FirstName.isEmpty()){
            firstname.setError("Firstname is Required");
            firstname.requestFocus();
            return;
        }

        if(LastName.isEmpty()){
            lastname.setError("lastname is Required");
            lastname.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(Email).matches()){
            email.setError("Enter Valid Email");
            email.requestFocus();
            return;
        }
        if(Password.isEmpty() && Password.length()<6){
            password.setError("Enter a valid Password");
            password.requestFocus();
            return;
        }

        if(Email.isEmpty()) {
            email.setError("Email Required");
            email.requestFocus();
            return;
        }


        if(Mobile.isEmpty()) {
            mobile.setError("Phone Number is Required");
            mobile.requestFocus();
            return;
        }

        Call<ResponseBody> call = RetrofitClient.getInstance()
                .getApi()
                .register(FirstName,LastName,Email,Password,Mobile);


        call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    try {
                        String s = response.body().string();
                        Toast.makeText(RegisterPage.this, s, Toast.LENGTH_SHORT).show();
                        Intent regist= new Intent(RegisterPage.this,LoginPage.class);
                        startActivity(regist);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Toast.makeText(RegisterPage.this,t.getMessage(),Toast.LENGTH_LONG).show();

                }
        });

            }


        });


        tvlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegisterPage.this,LoginPage.class);
                startActivity(i);
            }
        });

    }



}
