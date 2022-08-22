package com.example.sharedpreferenceexample;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnLogin = findViewById(R.id.logIn);
        btnLogin.setOnClickListener(view -> {
//                code for verification

//            get the shared preferences
            SharedPreferences pref = getSharedPreferences("login", MODE_PRIVATE);
//            set editor to change flag
            SharedPreferences.Editor editor = pref.edit();
//            change flag to true
            editor.putBoolean("flag", true);
//            apply changes
            editor.apply();

//            after changing sharedPreferences move to home page
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
        });
    }
}