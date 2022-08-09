package com.example.dessertplace;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
/*
* ThirdActivity
* */
public class ThirdActivity extends AppCompatActivity {
    /*
    * onCreate
    * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

//        Bundle to get values from SecondActivity intent
        Bundle bundle = getIntent().getExtras();
//        textView for line 1 containing name
        TextView textView1 = findViewById(R.id.ordered);
//        textView for line 2 containing order
        TextView textView2 = findViewById(R.id.result);
        if (bundle != null) {
            String result = bundle.getString("order");
            String personName = bundle.getString("personName");
            textView1.setText(String.format("Congratulations %s", personName));
            textView2.setText(String.format("Your order for %s is confirmed", result));
        }
    }
}