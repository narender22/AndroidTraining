package com.example.dessertplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
/*
* Main Activity
* */
public class MainActivity extends AppCompatActivity {
    /*
    * onCreate method
    * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
    * When user clicks on the submit button
    * */
    public void onSubmitClick(View view){
//        create an intent
        Intent intent=new Intent(this, SecondActivity.class);
//      create an instance of editText
        EditText editText=findViewById(R.id.personName);
//        convert the content in editText to string
        String personName = editText.getText().toString();
//        put personName in intent
        intent.putExtra("personName", personName);
//        send the intent to SecondActivity
        startActivity(intent);
    }
}