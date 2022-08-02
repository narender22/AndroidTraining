package com.example.radiobuttonexample;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/*
* Main activity
* */
public class MainActivity extends AppCompatActivity {
//    define radio button group
    private RadioGroup radioGenderGroup;

//    define a variable to get selected radio and get text from it
    private RadioButton radioGenderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        get the radio group
        radioGenderGroup = (RadioGroup) findViewById(R.id.radioGroup);

//        get the submit button
        Button submit = (Button) findViewById(R.id.button);

        submit.setOnClickListener(view -> {
//            get the id of selected radio button
            int selectedId = radioGenderGroup.getCheckedRadioButtonId();

//            get the radio button by Id
            radioGenderButton = (RadioButton) findViewById(selectedId);

//            toast to show text of the radio button selected.
            Toast.makeText(MainActivity.this, radioGenderButton.getText(), Toast.LENGTH_SHORT).show();
        });
    }
}