package com.example.assignment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class UserCheck extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_check);

        SharedPreferences pref = getSharedPreferences("login", MODE_PRIVATE);

        boolean check;
        check = pref.getBoolean("flag", false);

        Intent intent;
        if (check){
            intent = new Intent(UserCheck.this, MainActivity.class);
        }
        else{
            intent = new Intent(UserCheck.this, LoginActivity.class);
        }
        startActivity(intent);
    }
}