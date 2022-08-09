package com.example.dessertplace;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.dessertmenu, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.addIcon:
                Toast.makeText(this, "Add button clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.setting:
                Toast.makeText(this, "Setting menu clicked", Toast.LENGTH_SHORT).show();
                return true;
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