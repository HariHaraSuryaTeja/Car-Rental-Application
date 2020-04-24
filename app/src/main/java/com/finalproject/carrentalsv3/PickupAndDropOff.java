package com.finalproject.carrentalsv3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class PickupAndDropOff extends AppCompatActivity {
    private EditText pickupTime, dropTime, pickupDate, dropDate;
    AutoCompleteTextView startPt, endPt;
    Button findCars;
    String username;
    Calendar calendar;
    int pickUpSelectedHr = 0;
    int pickUpSelectedMin = 0;
    int dropSelectedHr = 0;
    int dropSelectedMin = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pickup_and_drop_off);

        String[] streets = getResources().getStringArray(R.array.streets);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_activated_1, streets);

        startPt = findViewById(R.id.startPoint);
        startPt.setThreshold(1);
        startPt.setAdapter(adapter);

        endPt = findViewById(R.id.endPoint);
        endPt.setThreshold(1);
        endPt.setAdapter(adapter);

        pickupTime = findViewById(R.id.pickupTime);
        dropTime = findViewById(R.id.dropTime);
        pickupDate = findViewById(R.id.pickupDate);
        dropDate = findViewById(R.id.dropDate);
        findCars = findViewById(R.id.findCars);
        username = getIntent().getStringExtra("userData");

        calendar = Calendar.getInstance();

        final DatePickerDialog.OnDateSetListener datePick = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, monthOfYear);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabelPickUp();
            }
        };

        pickupDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(PickupAndDropOff.this, datePick,
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        pickupTime.setText(pickUpSelectedHr + ":" + pickUpSelectedMin);

        pickupTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar currentTime = Calendar.getInstance();
                int hour = currentTime.get(Calendar.HOUR_OF_DAY);
                int minute = currentTime.get(Calendar.MINUTE);
                TimePickerDialog timePicker;
                timePicker = new TimePickerDialog(PickupAndDropOff.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        pickupTime.setText( selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                timePicker.setTitle("Select Time");
                timePicker.show();
            }
        });

        final DatePickerDialog.OnDateSetListener dateDrop = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, monthOfYear);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabelDrop();
            }
        };

        dropDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(PickupAndDropOff.this, dateDrop,
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        dropTime.setText(dropSelectedHr + ":" + dropSelectedMin);

        dropTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar currentTime = Calendar.getInstance();
                int hour = currentTime.get(Calendar.HOUR_OF_DAY);
                int minute = currentTime.get(Calendar.MINUTE);
                TimePickerDialog timePicker;
                timePicker = new TimePickerDialog(PickupAndDropOff.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        dropTime.setText( selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                timePicker.setTitle("Select Time");
                timePicker.show();
            }
        });

        findCars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String start=startPt.getText().toString();
                String end=endPt.getText().toString();
                if (TextUtils.isEmpty(start)  ){

                    startPt.setError("Please Select a City");
                    Toast.makeText(PickupAndDropOff.this,"Enter Valid street name",Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(end)){
                    endPt.setError("Please Select a City");
                    Toast.makeText(PickupAndDropOff.this,"Enter Valid street name",Toast.LENGTH_SHORT).show();

                }
                else
                {

                Intent intent = new Intent(PickupAndDropOff.this, CarSelection.class);
                intent.putExtra("userData", username);
                intent.putExtra("pickup_date", pickupDate.getText().toString());
                intent.putExtra("drop_date", dropDate.getText().toString());
                intent.putExtra("pickup_time", pickupTime.getText().toString());
                intent.putExtra("drop_time", dropTime.getText().toString());
                startActivity(intent);
            }

            }
        });
    }



    private void updateLabelPickUp() {
        String myFormat = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.getDefault());

        pickupDate.setText(sdf.format(calendar.getTime()));
    }

    private void updateLabelDrop() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        dropDate.setText(sdf.format(calendar.getTime()));
    }
}