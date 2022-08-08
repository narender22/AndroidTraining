package com.example.broadcastexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
    * broadcast a custom intent
    * */
    public void broadcastIntent(View view){
//        create a new intent
        Intent intent=new Intent();

//        set action for intent
        intent.setAction("com.tutorialspoint.CUSTOM_INTENT");

//        sent broadcast when button button is clicked
        sendBroadcast(intent);
    }
}