package com.example.spinnerexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
/*
* Main activity
* */
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        create an object for the spinner
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
//        this will be called when an item is selected
        spinner.setOnItemSelectedListener(this);

//        create a list of countries to be added to the spinner and add data to it
        ArrayList<String> country = new ArrayList<>();
        country.add("India");
        country.add("Germany");
        country.add("USA");
        country.add("Canada");
        country.add("China");
        country.add("Australia");
        country.add("Egypt");

//        pass the data to the spinner
        ArrayAdapter<String> countryad = new ArrayAdapter<> (this, android.R.layout.simple_spinner_item, country);
        spinner.setAdapter(countryad);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//        get the selected item and convert it to string
        String item = adapterView.getItemAtPosition(i).toString();

//        toast to show the selected item
        Toast.makeText(getApplicationContext(), "You have selected  : " + item, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        /*
        * if nothing is selected from the spinner
        * */
    }
}