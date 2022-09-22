package com.example.assignment;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerDataAdapter extends RecyclerView.Adapter<RecyclerDataAdapter.ViewHolder> {
    Context context;
    ArrayList<DataModel> arrayData;

    public RecyclerDataAdapter(Context context, ArrayList<DataModel> arrayData){
        this.context = context;
        this.arrayData = arrayData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.activity_data_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imgTick.setImageResource(arrayData.get(position).img);
        holder.amountF.setText(String.valueOf(arrayData.get(position).amount));
        holder.category.setText(arrayData.get(position).category);

        holder.llrow.setOnClickListener(view -> {
            Intent intent = new Intent(context, CategoryInformation.class);
            intent.putExtra("category", arrayData.get(position).category);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return arrayData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView category, amountF;
        ImageView imgTick;
        LinearLayout llrow;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            category = itemView.findViewById(R.id.category);
            amountF = itemView.findViewById(R.id.amountF);
            imgTick = itemView.findViewById(R.id.imgTick);
            llrow = itemView.findViewById(R.id.llrow);
        }
    }
}
