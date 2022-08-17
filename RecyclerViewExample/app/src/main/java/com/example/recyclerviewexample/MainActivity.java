package com.example.recyclerviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
/*
* Main Activity
* */
public class MainActivity extends AppCompatActivity {
/*
* Array list for data
* */
ArrayList<ContactModel> arrayContact = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Create an instance of RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerContact);
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
        RecyclerContactAdapter adapter = new RecyclerContactAdapter(this, arrayContact);
//        set adapter for recyclerView
        recyclerView.setAdapter(adapter);
    }
}