package com.example.sharedpreferenceexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(() -> {
//                create a shared preference
//                set login key as private
            SharedPreferences pref = getSharedPreferences("login", MODE_PRIVATE);
//                set flag key as false default
            boolean check;
            check = pref.getBoolean("flag", false);

//            check flag of SharedPreferences
            Intent intent;
            if (check){
                intent = new Intent(MainActivity.this, HomeActivity.class);
            }
            else{
                intent = new Intent(MainActivity.this, LoginActivity.class);
            }
            startActivity(intent);

        }, 4000);
    }
}