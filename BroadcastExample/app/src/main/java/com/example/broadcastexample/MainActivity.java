package com.example.broadcastexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "main activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
    * broadcast a custom intent
    * */
    public void broadcastIntent(View view){
        Log.d(TAG, "broadcastIntent: Button clicked");
//        create a new intent
        Intent intent=new Intent();

//        set action for intent
        intent.setAction("com.tutorialspoint.CUSTOM_INTENT");

//        sent broadcast when button button is clicked
        sendBroadcast(intent);
        Log.d(TAG, "broadcastIntent: broadcast sent");
    }
}