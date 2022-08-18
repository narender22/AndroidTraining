package com.example.dessertplace;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

/*
 * Main Activity
 * */
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivityLog";
    /*
     * onCreate method
     * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /*
     * To add menu is MainActivity
     * */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.dessertmenu, menu);
        return true;
    }

    /*
     * define menu click/select
     * */
    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        /*
         * item is the menu item that is clicked/selected
         * */
        switch (item.getItemId()) {
//            when shop icon is selected
            case R.id.shop:
                Toast.makeText(this, "Shop menu selected", Toast.LENGTH_SHORT).show();
                return true;
//          when info icon  is selected
            case R.id.info:
                Toast.makeText(this, "Info menu selected", Toast.LENGTH_SHORT).show();
                return true;
//            when favorites menu is selected
            case R.id.favorites:
                Toast.makeText(this, "Favorites menu selected", Toast.LENGTH_SHORT).show();
                return true;
//            when contact menu is selected
            case R.id.contact:
                Toast.makeText(this, "Contact menu selected", Toast.LENGTH_SHORT).show();
                return true;
//                if nothing is selected from menu
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /*
     * When user clicks on the submit button
     * */
    public void onSubmitClick(View view) {
        Log.d(TAG, "onSubmitClick: submit button clicked");
//        create an intent
        Intent intent = new Intent(this, SecondActivity.class);
//      create an instance of editText
        EditText editText = findViewById(R.id.personName);
//        convert the content in editText to string
        String personName = editText.getText().toString();
//        put personName in intent
        intent.putExtra("personName", personName);
        Log.d(TAG, "onSubmitClick: intent created");
//        send the intent to SecondActivity
        startActivity(intent);
        Log.d(TAG, "onSubmitClick: intent called");

    }
}