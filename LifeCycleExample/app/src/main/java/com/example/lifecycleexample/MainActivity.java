package com.example.lifecycleexample;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
//    log string
    private static final String TAG = "Lifecycle main activity";

    /*
    * onCreate: When app is created
    * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });
        /* Log  */
        Log.d(TAG, "This is the log for onCreate.");
    }

    /*
    * onStart: When app is visible to user
    * */
    @Override
    protected void onStart() {
        super.onStart();

        /* Log */
        Log.d(TAG, "This is the log for onStart.");
    }

    /*
    * onResume: When user start interacting with app
    * */
    @Override
    protected void onResume() {
        super.onResume();

        /* Log */
        Log.d(TAG, "This is the log for onResume");
    }

    /*
    * onPause: When is not visible to the user or other app is opened with closing this
    * */
    @Override
    protected void onPause() {
        super.onPause();

        /* Log */
        Log.d(TAG, "This is the log for onPause");
    }

    /*
    * onStop: When app is no longer visible to the user, it frees the memory.
    * */
    @Override
    protected void onStop() {
        super.onStop();

        /* Log */
        Log.d(TAG, "This is the log for onStop");
    }

    /*
    * onRestart: When app is again started, prior destroy.
    * */
    @Override
    protected void onRestart() {
        super.onRestart();

        /* Log */
        Log.d(TAG, "This is the log for onRestart");
    }

    /*
    * onDestroy: Just before app is destroyed
    * */
    @Override
    protected void onDestroy() {
        super.onDestroy();

        /* Log */
        Log.d(TAG, "This is the log for onDestroy");
    }
}