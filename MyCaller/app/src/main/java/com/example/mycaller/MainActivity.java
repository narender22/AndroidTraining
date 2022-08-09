package com.example.mycaller;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "main activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        create editText to get mobile number
        EditText editText = findViewById(R.id.editTextPhone);
        if (editText != null){
            editText.setOnEditorActionListener((textView, i, keyEvent) -> {
//                flag to check if number is sent
                boolean handled = false;
                if (i == EditorInfo.IME_ACTION_SEND){
//                    send the number to method
                    dialNumber();
                    handled = true;
                }
                return handled;
            });
        }
    }
/*
* Method to send the number to dialer
* */
    private void dialNumber(){
//        find the editTextPhone view
        EditText editText = findViewById(R.id.editTextPhone);
        String phoneNum = null;
//        if the editText field is not null
//        concatenate "tel: " with the phone number string.
        if (editText != null){
            phoneNum = "tel: " + editText.getText().toString();
        }
//        Optional: Log the concatenated phone number for dialing
        Log.d(TAG, "dialNumber: " + phoneNum);
        
//        specify the intent
        Intent intent = new Intent(Intent.ACTION_DIAL);
//        set the data for the intent as the phone number
        intent.setData(Uri.parse(phoneNum));
        
//        if the intent resolves to a package (app)
//        start the activity with the intent
        startActivity(intent);
    }
}