package com.example.servicexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    /*
    * When activity starts
    * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
    * This will be called when we click on start service button
    * */
    public void startService(View view) {
        startService(new Intent(getBaseContext(), MyService.class));
    }

    /*
    * This will be called when we click on stop service button
    * */
    public void stopService(View view){
        stopService(new Intent(getBaseContext(), MyService.class));
    }
}