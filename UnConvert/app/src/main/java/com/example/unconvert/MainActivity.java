package com.example.unconvert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * main activity
 */
public class MainActivity extends AppCompatActivity {
//    use TextView to display the converted value in pounds
    private TextView textView;
//    use EditText to get the value in KG to be converted
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        button to be clicked on
        Button button = findViewById(R.id.button);
//        textView to display value in pounds
        textView = findViewById(R.id.textView2);
//        editText to get the KG value to be converted
        editText = findViewById(R.id.editTextTextPersonName2);
//        When the user clicks on submit button
        button.setOnClickListener(view -> {
            /* get the value and convert it to string */
            String s = editText.getText().toString();
            /* convert the string value to number */
            int kg = Integer.parseInt(s);
            /* convert KG to pounds */
            double pound = 2.204 * kg;
            /* Finally show the value in pounds in the textView */
            textView.setText(String.format("Pound value = %s", pound));
        });


    }
}