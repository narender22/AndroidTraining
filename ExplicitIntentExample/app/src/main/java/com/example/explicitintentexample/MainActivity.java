package com.example.explicitintentexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/*
* Main Activity
* */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /*
    * When "send index" button is clicked this function will be called
    * */
     public void onIndexSendClick(View view) {
//        first set the intent to the second activity
         Intent intent = new Intent(this, SecondActivity.class);

//         editText have thee index of the image to be displayed
         EditText editText = findViewById(R.id.editText);

//         convert the index entered to string for usage
         String index = editText.getText().toString();

//         load the index in intent
         intent.putExtra("imageIndex", index);

//         pass the index to second activity to show the image accordingly
         startActivity(intent);
     }
}