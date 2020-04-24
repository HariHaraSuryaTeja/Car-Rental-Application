package com.finalproject.carrentalsv3;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CarsAdapter  extends  RecyclerView.Adapter<CarsAdapter.ViewHolder> {

    private static final String TAG = "CarsAdapter";

    List<CarData> Data;
    Context context;

    public CarsAdapter(List<CarData> data, Context context) {
        this.Data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public CarsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cars_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarsAdapter.ViewHolder holder, int position) {
        final CarData carData=Data.get(position);
        holder.nameofcar.setText(carData.getCarName());
        holder.priceofcar.setText(carData.getCarPrice());
        holder.ageofcar.setText(carData.getCarYear());
        holder.decriptionofcar.setText(carData.getCarDescription());
        holder.imageofcar.setImageDrawable(context.getResources().getDrawable(carData.Carimage));
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,CarConfirmation.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("Carimage",carData.getCarimage());
                intent.putExtra("Carname",carData.getCarName());
                intent.putExtra("Carprice",carData.getCarPrice());
                intent.putExtra("Caryear",carData.getCarYear());
                intent.putExtra("Cardescription",carData.getCarDescription());
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return Data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageofcar;
        TextView nameofcar,priceofcar,ageofcar,decriptionofcar;
        RelativeLayout relativeLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageofcar=itemView.findViewById(R.id.Car_image);
            nameofcar=itemView.findViewById(R.id.Car_name);
            priceofcar=itemView.findViewById(R.id.Car_price);
            ageofcar=itemView.findViewById(R.id.Car_year);
            decriptionofcar=itemView.findViewById(R.id.Car_description);
            relativeLayout=itemView.findViewById(R.id.relativelist);
        }
    }
}
