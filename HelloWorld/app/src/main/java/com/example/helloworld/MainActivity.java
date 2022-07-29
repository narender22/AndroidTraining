package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

/**
 * main activity
* */
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MyActivity";
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //    textview to display required message
        TextView textView = findViewById(R.id.Hello);
//        Set the text of textView to the required text
        textView.setText("Hello World!");
        /*
        ***  logs   ***
        * */
        Log.d(TAG, "This is a log for DEBUG");

        Log.e(TAG, "This is a log for ERROR");

        Log.v(TAG, "This is a log for VERBOSE");

        Log.i(TAG, "This is a log for INFO");

        Log.w(TAG, "this is a log for WARN");
    }
}