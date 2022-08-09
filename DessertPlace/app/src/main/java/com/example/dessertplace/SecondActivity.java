package com.example.dessertplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/*
 * Second Activity
 * */
public class SecondActivity extends AppCompatActivity {
    private static final String TAG = "SecondActivityLog";
    
    //    defining some variables to be used
    Intent intent2;
    Bundle bundle;
    String personName;

    /*
     * onCreate
     * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d(TAG, "onCreate: onCreate started");
        //    intent from SecondActivity to ThirdActivity
        intent2 = new Intent(this, ThirdActivity.class);
        //    bundle for second activity
        bundle = getIntent().getExtras();
        //    convert the intent content to string
        personName = bundle.getString("personName");
        Log.d(TAG, "onCreate: variable Instances created");
        /*
         * setting text view from MainActivity
         * */
        if (bundle != null) {
//            create an instance of textView
            Log.d(TAG, "onCreate: title changed");
            TextView textView = findViewById(R.id.title2);
            textView.setText(String.format("Hello %s", personName));
        }
    }

    /*
     * When cake image is clicked
     * personName and dessert name will be sent
     * */
    public void onCakeClick(View view) {
        Log.d(TAG, "onCakeClick: Cake image clicked");
        intent2.putExtra("order", "cake");
        intent2.putExtra("personName", personName);
        startActivity(intent2);
    }

    /*
     * When Ice Cream image is clicked
     * personName and dessert name will be sent
     * */
    public void onIceCreamClick(View view) {
        Log.d(TAG, "onIceCreamClick: Ice cream image clicked");
        intent2.putExtra("order", "Ice Cream");
        intent2.putExtra("personName", personName);
        startActivity(intent2);
    }

    /*
     * When Donut image is clicked
     * personName and dessert name will be sent
     * */
    public void onDonutClick(View view) {
        Log.d(TAG, "onDonutClick: Donut image clicked");
        intent2.putExtra("order", "Donut");
        intent2.putExtra("personName", personName);
        startActivity(intent2);
    }
}