package com.example.dessertplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
/*
* Second Activity
* */
public class SecondActivity extends AppCompatActivity {
//    intent from SecondActivity to ThirdActivity
    Intent intent2=new Intent(this, ThirdActivity.class);
//    bundle for second activity
    Bundle bundle=getIntent().getExtras();
//    convert the intent content to string
    String personName = bundle.getString("personName");

    /*
    * onCreate
    * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        /*
        * setting text view from MainActivity
        * */
        if (bundle != null){
            TextView textView = findViewById(R.id.title2);
            textView.setText(String.format("Hello %s", personName));
        }
    }
    /*
    * When cake image is clicked
    * personName and dessert name will be sent
    * */
    public void onCakeClick(View view){
        intent2.putExtra("order", "cake");
        intent2.putExtra("personName", personName);
        startActivity(intent2);
    }

    /*
     * When Ice Cream image is clicked
     * personName and dessert name will be sent
     * */
    public void onIceCreamClick(View view){
        intent2.putExtra("order", "Ice Cream");
        intent2.putExtra("personName", personName);
        startActivity(intent2);
    }

    /*
     * When Donut image is clicked
     * personName and dessert name will be sent
     * */
    public void onDonutClick(View view){
        intent2.putExtra("order", "Donut");
        intent2.putExtra("personName", personName);
        startActivity(intent2);
    }
}