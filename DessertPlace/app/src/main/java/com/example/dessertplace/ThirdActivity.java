package com.example.dessertplace;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Bundle bundle = getIntent().getExtras();
        TextView textView1 = findViewById(R.id.ordered);
        TextView textView2 = findViewById(R.id.result);
        if (bundle != null){
            String result = bundle.getString("order");
            String personName = bundle.getString("personName");
            textView1.setText(String.format("Congratulations %s", personName));
            textView2.setText(String.format("Your order for %s is confirmed", result));
        }
    }
}