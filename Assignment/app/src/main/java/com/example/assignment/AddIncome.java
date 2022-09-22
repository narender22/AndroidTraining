package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.Calendar;

public class AddIncome extends AppCompatActivity {
    Button datePicker;
    MyDbHelper dbHelper = new MyDbHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_income);

        Button okButton = findViewById(R.id.ok);
        Button cancelButton = findViewById(R.id.cancel);

        EditText amount = findViewById(R.id.amount);
        datePicker = findViewById(R.id.datePicker);
        EditText remarks = findViewById(R.id.remarks);

        setDatePickerDate();

        okButton.setOnClickListener(view -> {
            String amountS = amount.getText().toString();
            String remarkS = remarks.getText().toString();
            Intent intent = new Intent(this, MainActivity.class);
            dbHelper.addData("Income", amountS, remarkS);
            startActivity(intent);
        });

        cancelButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

        datePicker.setOnClickListener(view -> {
            DialogFragment dialogFragment = new IncomeDatePickerFragment();
            dialogFragment.show(getSupportFragmentManager(), "datePicker");
        });

    }
    private void setDatePickerDate() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        processDate(year, month, day);
    }
    public void processDate(int year, int month, int day) {
        String month_string = Integer.toString(month + 1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        String result = month_string + "/" + day_string + "/" + year_string;
        datePicker.setText(result);
    }
}