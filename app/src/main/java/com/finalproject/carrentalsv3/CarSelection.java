package com.finalproject.carrentalsv3;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class CarSelection  extends AppCompatActivity {
    RecyclerView recyclerView;

    List<CarData> dataofcar;

    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_selection);
        dataofcar=new ArrayList<>();
        recyclerView=findViewById(R.id.Carlist);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        dataofcar.add(new CarData(R.drawable.tesla,"Tesla","300$","2020","This is a eco-friendly vehicle as it uses electricity as fule"));
        dataofcar.add(new CarData(R.drawable.honda,"Honda","200$","2019","This is a petrol varient"));
        dataofcar.add(new CarData(R.drawable.toyotaprius,"Toyota","150$","2020","This is a eco-friendly vehicle as it uses electricity as fule"));
        dataofcar.add(new CarData(R.drawable.toyotasedan,"Toyota","100$","2018","this uses petrol as fuel"));
        dataofcar.add(new CarData(R.drawable.audia6,"Audi A6","250$","2020","This vehicle is for people why prefer to travel in style"));
        dataofcar.add(new CarData(R.drawable.bmw,"BMW","300$","2019","This vehicle is for people who preffer comfort"));
        dataofcar.add(new CarData(R.drawable.aventador,"Lamborgini","500$","2019","This is for people who prefer class"));
        dataofcar.add(new CarData(R.drawable.ferari,"Ferari","400$","2019","This is for people who prefer class"));
        adapter=new CarsAdapter(dataofcar,getApplicationContext());
        recyclerView.setAdapter(adapter);

    }
}
