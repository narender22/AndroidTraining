package com.example.recyclerviewexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
/*
* Create an adapter for recycler view to pass data to the specific views
* */
public class RecyclerContactAdapter extends RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder> {
    Context context;
    ArrayList<ContactModel> arrayContact;

    /*
    * creating constructor to call pass arguments to class
    * */
    RecyclerContactAdapter(Context context, ArrayList<ContactModel> arrayContact) {
        this.context = context;
        this.arrayContact = arrayContact;
    }


    /*
    * When recycleView is created
    * */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        set inflater which will return a view
        View view = LayoutInflater.from(context).inflate(R.layout.contact_row, parent, false);
//        return view in a view holder as described below
        return new ViewHolder(view);
    }


    /*
    * bind recycle view with views of activity
    * */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imgContact.setImageResource(arrayContact.get(position).img);
        holder.txtNumber.setText(arrayContact.get(position).number);
        holder.txtName.setText(arrayContact.get(position).name);
    }

    /*
    * set the count of item
    * */
    @Override
    public int getItemCount() {

        return arrayContact.size();
    }

    /*
    *   create a view holder according to problem to show content properly
    * */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtNumber;
        ImageView imgContact;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            /*
            * txtName is contact's name
            * txtNumber is contact's number
            * imgContact is contact's photo
            * */
            txtName = itemView.findViewById(R.id.txtName);
            txtNumber = itemView.findViewById(R.id.txtNumber);
            imgContact = itemView.findViewById(R.id.imgContact);
        }
    }

}
