package com.example.recyclerviewexample;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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
        ContactModel model = arrayContact.get(position);
        holder.imgContact.setImageResource(model.img);
        holder.txtNumber.setText(model.number);
        holder.txtName.setText(model.name);

        holder.llrow.setOnClickListener(view -> {
//            set dialog to be displayed
            Dialog dialog =  new Dialog(context);
            dialog.setContentView(R.layout.add_update_lay);

//            define variable for name, number, title and button
            EditText edtName = dialog.findViewById(R.id.edtName);
            EditText edtNumber = dialog.findViewById(R.id.edtNumber);
            Button btnAction = dialog.findViewById(R.id.btnAction);
            TextView addTitle = dialog.findViewById(R.id.addTitle);

//            change title and button text to update
            addTitle.setText(R.string.update_contact);
            btnAction.setText(R.string.update);

//            set the name and number of the row clicked in the edit text
            edtName.setText(arrayContact.get(position).name);
            edtNumber.setText(arrayContact.get(position).number);

//            when update button is clicked
            btnAction.setOnClickListener(view12 -> btnAction.setOnClickListener(view1 -> {
                String name="", number="";
//                check for name and number
                if (!edtName.getText().toString().equals("")){
                    name =  edtName.getText().toString();
                }
                else {
                    Toast.makeText(context, "Please enter a valid name", Toast.LENGTH_SHORT).show();
                }

                if (!edtNumber.getText().toString().equals("")) {
                    number = edtNumber.getText().toString();
                }else {
                    Toast.makeText(context, "Invalid Number", Toast.LENGTH_SHORT).show();
                }

//                change the name and number in array
                arrayContact.set(position, new ContactModel(arrayContact.get(position).img, name, number));
//                to notify about item change
                notifyItemChanged(position);
//                dismiss the dialog at end
                dialog.dismiss();
            }));
//            show dialog
            dialog.show();
        });

        holder.llrow.setOnLongClickListener(view -> {

            AlertDialog.Builder builder = new AlertDialog.Builder(context).setTitle("Delete contact")
                    .setMessage("Are you sure you want to delete this Contact")
                    .setIcon(R.drawable.ic_baseline_delete_24)
                    .setPositiveButton("Yes", (dialogInterface, i) -> {
                        arrayContact.remove(position);
                        notifyItemRemoved(position);
                    }).setNegativeButton("No", (dialogInterface, i) -> {
                    });
            builder.show();

            return true;
        });
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
        LinearLayout llrow;

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
