package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class CategoryInformation extends AppCompatActivity {
    MyDbHelper dbHelper = new MyDbHelper(this);
    ArrayList<DataModel> arrayData = new ArrayList<>();
    TextView totalAmount, noOfEntries;
    RecyclerView dataRecycler;
    RecyclerCategoryDataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_information);

        int total, count;

        dataRecycler = findViewById(R.id.dataRecycler);
        totalAmount = findViewById(R.id.totalAmount);
        noOfEntries = findViewById(R.id.noOfEntries);

        Bundle bundle = getIntent().getExtras();

        arrayData = dbHelper.getCategoryData(bundle.getString("category"));
        total = dbHelper.getCategoryTotal(bundle.getString("category"));
        count = dbHelper.getCategoryCount(bundle.getString("category"));

        totalAmount.setText(String.valueOf(total));
        noOfEntries.setText(String.valueOf(count));

        dataRecycler.setLayoutManager(new LinearLayoutManager(this));

        adapter = new RecyclerCategoryDataAdapter(CategoryInformation.this, arrayData);

        dataRecycler.setAdapter(adapter);

    }
}