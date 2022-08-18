package com.example.dessertplace;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
/*
* To display splash screen in app
* */
@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        /*
        * to handle the splash screen we add a handler
        * move to main activity after 2 sec
        * */
        new Handler().postDelayed(() -> {
//            intent to move to main activity
            Intent main = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(main);
        }, 2000);
    }
}