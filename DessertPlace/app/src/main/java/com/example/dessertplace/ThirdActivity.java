package com.example.dessertplace;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

import android.widget.DatePicker;

/*
 * ThirdActivity
 * */
public class ThirdActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
//    create an instance of radio group
    private RadioGroup orderRadioGroup;
//    create an instance of radio button which will be selected
    private RadioButton orderRadioButton;
//    instance for datePicker button
    private Button dateButton;
//    define year, month and day
    private int year, month, day;

    /*
     * onCreate
     * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

//        setting the back button in the menu bar
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
//
        dateButton = findViewById(R.id.datePicker);
        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
        dateButton.setText(new StringBuilder().append(day).append("/").append(month).append("/").append(year));

        /*
         * Create spinner
         * */
        Spinner mobileSpinner = findViewById(R.id.mobileSpinner);
        if (mobileSpinner != null) {
            mobileSpinner.setOnItemSelectedListener(this);
        }
        ArrayList<String> place = new ArrayList<>();
        place.add("Home");
        place.add("Work");
        place.add("Mobile");
        place.add("Other");

//        create ArrayAdapter using the string array and default spinner layout
        ArrayAdapter<String> placeAd = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, place);
        if (mobileSpinner != null) {
            mobileSpinner.setAdapter(placeAd);
        }


//        Bundle to get values from SecondActivity intent
        Bundle bundle = getIntent().getExtras();
//        textView for line 1 containing name
        TextView textView1 = findViewById(R.id.ordered);
//        textView for line 2 containing order
        TextView textView2 = findViewById(R.id.result);
        if (bundle != null) {
            String result = bundle.getString("order");
            String personName = bundle.getString("personName");
            textView1.setText(String.format("Congratulations %s", personName));
            textView2.setText(String.format("Your order for %s is confirmed", result));
        }

//        EditText address=findViewById(R.id.editTextAddress);
//        EditText number=findViewById(R.id.editTextNumber);
//        EditText note=findViewById(R.id.editTextNote);
//        get the radio group
        orderRadioGroup = findViewById(R.id.deliveryOptions);

        Button submit = findViewById(R.id.submit2);

        submit.setOnClickListener(view -> {
//            get the id of selected radio
            int selectedId = orderRadioGroup.getCheckedRadioButtonId();
            orderRadioButton = findViewById(selectedId);
//            setting the ALERT dialog and message
            AlertDialog myAlertBuilder = new AlertDialog.Builder(ThirdActivity.this)
                    .setTitle("Message")
                    .setMessage(new StringBuilder().append(orderRadioButton.getText()).append(" for ").append(day).append("/").append(month + 1).append("/").append(year))
                    .setPositiveButton("OK", (dialogInterface, i) -> dialogInterface.dismiss()).create();
            myAlertBuilder.show();
//            Toast.makeText(this, orderRadioButton.getText(), Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String spinnerLabel = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(this, spinnerLabel, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Toast.makeText(this, "Please select your contact type.", Toast.LENGTH_SHORT).show();
    }

    @SuppressWarnings("deprecation")
    public void setDate(View view)
    {
        showDialog(999);
    }

    private final DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int yr, int mon, int dy) {
            year = yr;
            month = mon;
            day = dy;
            dateButton.setText(new StringBuilder().append(day).append("/").append(month + 1).append("/").append(year));
        }
    };

    @SuppressWarnings("deprecation")
    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this, myDateListener, year, month, day);
        }
        return null;
    }
}