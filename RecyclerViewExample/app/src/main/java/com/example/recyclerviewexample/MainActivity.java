package com.example.recyclerviewexample;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
/*
* Main Activity
* */
public class MainActivity extends AppCompatActivity {
/*
* Array list for data
* */
ArrayList<ContactModel> arrayContact = new ArrayList<>();
// define variables for adapter and recyclerView
RecyclerContactAdapter adapter;
RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Create an instance of RecyclerView
        recyclerView = findViewById(R.id.recyclerContact);
//        describe the layout for recyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        add data to arraylist
        arrayContact.add(new ContactModel(R.drawable.a1, "A1", "0000000001"));
        arrayContact.add(new ContactModel(R.drawable.a2, "A2", "0000000002"));
        arrayContact.add(new ContactModel(R.drawable.a3, "A3", "0000000003"));
        arrayContact.add(new ContactModel(R.drawable.a4, "A4", "0000000004"));
        arrayContact.add(new ContactModel(R.drawable.a5, "A5", "0000000005"));
        arrayContact.add(new ContactModel(R.drawable.a6, "A6", "0000000006"));
        arrayContact.add(new ContactModel(R.drawable.a7, "A7", "0000000007"));
        arrayContact.add(new ContactModel(R.drawable.a8, "A8", "0000000008"));
        arrayContact.add(new ContactModel(R.drawable.a9, "A9", "0000000009"));
        arrayContact.add(new ContactModel(R.drawable.a10, "A10", "0000000010"));
        arrayContact.add(new ContactModel(R.drawable.a11, "A11", "0000000011"));

//        call RecyclerContact adapter created
        adapter = new RecyclerContactAdapter(MainActivity.this, arrayContact);
//        set adapter for recyclerView
        recyclerView.setAdapter(adapter);

    }
/*
* When floating button is clicked
* */
    public void floatingButtonClick(View view) {
//        set dialog
        Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.add_update_lay);
//        define variables required for name and number
        EditText edtName = dialog.findViewById(R.id.edtName);
        EditText edtNumber = dialog.findViewById(R.id.edtNumber);
        Button btnAction = dialog.findViewById(R.id.btnAction);
//        when add button is clicked from dialog
        btnAction.setOnClickListener(view1 -> {
            String name="", number="";
//            check for name and number
//                proceed if found else toast
            if (!edtName.getText().toString().equals("")){
                name =  edtName.getText().toString();
            }
            else {
                Toast.makeText(MainActivity.this, "Please enter a valid name", Toast.LENGTH_SHORT).show();
            }
            if (!edtNumber.getText().toString().equals("")) {
                number = edtNumber.getText().toString();
            }else {
                Toast.makeText(MainActivity.this, "Invalid Number", Toast.LENGTH_SHORT).show();
            }

//            add name and number to the array list
            arrayContact.add(new ContactModel(R.drawable.a1, name, number));
//            notify about new item insertion
            adapter.notifyItemInserted(arrayContact.size()-1);

//            scroll to new item added
            recyclerView.scrollToPosition(arrayContact.size()-1);
//            dismiss the dialog box at end
            dialog.dismiss();

        });
//        to show the dialog on click
        dialog.show();
    }

}