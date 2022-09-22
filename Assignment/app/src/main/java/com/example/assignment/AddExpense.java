package com.example.assignment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;
import java.util.Calendar;

public class AddExpense extends AppCompatActivity {
    Button datePicker;
    MyDbHelper dbHelper = new MyDbHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);

        Button submit = findViewById(R.id.save);
        Button close = findViewById(R.id.close);
        datePicker = findViewById(R.id.datePicker);
        EditText amount = findViewById(R.id.amount);
        EditText remarks = findViewById(R.id.remarks);
        Spinner spinner = findViewById(R.id.spinner);

        setDatePickerDate();

        ArrayList<String> expense = new ArrayList<>();
        expense.add("Food");
        expense.add("Investment");
        expense.add("Family");
        expense.add("Daily Necessities");
        expense.add("Debt & Loan");
        expense.add("Budget Balance");


        ArrayAdapter<String> expenseAd = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, expense);
        spinner.setAdapter(expenseAd);

        submit.setOnClickListener(view -> {
            String amountS = amount.getText().toString();
            String remarkS = remarks.getText().toString();
            String categorySelected = spinner.getSelectedItem().toString();
            Intent intent = new Intent(AddExpense.this, MainActivity.class);
            dbHelper.addData(categorySelected, amountS, remarkS);
            startActivity(intent);
        });

        close.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

        datePicker.setOnClickListener(view -> {
            DialogFragment dialogFragment = new DatePickerFragment();
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
        String result = (month_string + "/" + day_string + "/" + year_string);
        datePicker.setText(result);

    }

}