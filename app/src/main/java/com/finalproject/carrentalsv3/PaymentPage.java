package com.finalproject.carrentalsv3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PaymentPage extends AppCompatActivity {

    Spinner spinner;
    String pay;
    Button Confirmation;
    EditText card,name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_page);
        spinner=findViewById(R.id.paymentlist);
        card=findViewById(R.id.cardnumber);
        name=findViewById(R.id.cusname);
        Confirmation=findViewById(R.id.pytmbtn);
        List<String> payment=new ArrayList<>();
        payment.add(0,"Select Card Type");
        payment.add(1,"Credit Card");
        payment.add(2,"Debit Card");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,payment);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long id) {
                if (adapterView.getItemAtPosition(i).equals("Select Card Type")){

                }
                else {
                    pay=adapterView.getItemAtPosition(i).toString();
                    Toast.makeText(PaymentPage.this,"Selected"+pay,Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Confirmation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cardetails=card.getText().toString();
                String username=name.getText().toString();
                if (cardetails.length()<16 && cardetails.isEmpty()){

                    card.setError("Enter Valid Card details");
                    Toast.makeText(PaymentPage.this,"Enter Valid Card",Toast.LENGTH_SHORT).show();


                }
                else {

                    Intent confrim=new Intent(getApplicationContext(), BookingConfirmation.class);
                    startActivity(confrim);

                }

                if (TextUtils.isEmpty(username)){
                    name.setError("Mandatory Field");
                    Toast.makeText(PaymentPage.this,"Enter Valid Name",Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent confrim=new Intent(getApplicationContext(), BookingConfirmation.class);
                    startActivity(confrim);
                }

            }
        });
    }
}
