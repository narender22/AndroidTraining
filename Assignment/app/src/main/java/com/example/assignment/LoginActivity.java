package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText userName = findViewById(R.id.userName);
        EditText password = findViewById(R.id.password);
        Button login = findViewById(R.id.loginButton);

        login.setOnClickListener(view -> {
            String username = userName.getText().toString();
            String passWord = password.getText().toString();

            SharedPreferences pref = getSharedPreferences("login", MODE_PRIVATE);
            SharedPreferences.Editor editor = pref.edit();
            editor.putBoolean("flag", true);
            editor.apply();

            if(username.equals("Narendra") && passWord.equals("Anand")){
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
            else{
                Toast.makeText(this, "Incorrect Credentials, Try Again", Toast.LENGTH_SHORT).show();
            }


        });

    }
}