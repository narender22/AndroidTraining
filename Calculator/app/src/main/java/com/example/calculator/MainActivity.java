package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView result;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Operation operation = new Operation();

        result = findViewById(R.id.textView);
        Button calculate = findViewById(R.id.calculate);

//        get numbers
        EditText number1 = findViewById(R.id.number1);
        EditText number2 = findViewById(R.id.number2);

//        get radio button group
        radioGroup = findViewById(R.id.radioGroup);

        calculate.setOnClickListener(view -> {
//            get id of radio button
            int selectId = radioGroup.getCheckedRadioButtonId();

            String num1 = number1.getText().toString();
            String num2 = number2.getText().toString();
            int n1 = Integer.parseInt(num1);
            int n2 = Integer.parseInt(num2);

//            get the radio button by id
            radioButton = findViewById(selectId);
            String task = (String) radioButton.getText();
            switch (task){
                case "+":
                    result.setText(Integer.toString(operation.add(n1, n2)));
                    break;
                case "-":
                    result.setText(Integer.toString(operation.sub(n1, n2)));
                    break;
                case "*":
                    result.setText(Integer.toString(operation.mul(n1, n2)));
                    break;
                case "/":
                    result.setText(Integer.toString(operation.div(n1, n2)));
                    break;
                default:
                    Toast.makeText(this, "Select an operation first", Toast.LENGTH_SHORT).show();
            }
        });

    }
}