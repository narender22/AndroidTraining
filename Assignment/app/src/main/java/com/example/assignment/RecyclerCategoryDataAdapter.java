package com.example.assignment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerCategoryDataAdapter extends RecyclerView.Adapter<RecyclerCategoryDataAdapter.ViewHolder> {
    Context context;
    ArrayList<DataModel> arrayData;

    public RecyclerCategoryDataAdapter(Context context, ArrayList<DataModel> arrayData) {
        this.context = context;
        this.arrayData = arrayData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_data_details_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DataModel model = arrayData.get(position);
        holder.dataAmount.setText(String.valueOf(model.amount));
        holder.dataCategory.setText(model.category);
        holder.dataRemark.setText(model.remarks);

    }

    @Override
    public int getItemCount() {
        return arrayData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView dataAmount, dataCategory;
        TextView dataRemark;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            dataAmount = itemView.findViewById(R.id.dataAmount);
            dataCategory = itemView.findViewById(R.id.dataCategory);
            dataRemark = itemView.findViewById(R.id.dataRemark);
        }
    }
}
