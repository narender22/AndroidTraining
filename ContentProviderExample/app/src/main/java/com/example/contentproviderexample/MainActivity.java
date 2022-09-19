package com.example.contentproviderexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "CONTACT_PROVIDER_DEMO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//    on button click
    public void btnGetContact(View view) {
        getPhoneContacts();
    }

    private void getPhoneContacts(){
//        first check if the user has provided permission
//        if not ask again
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_CONTACTS}, 0);
        }

        ContentResolver contentResolver = getContentResolver();
//        get URI for phone contacts
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
//        set a cursorLoader for contacts
        Cursor cursor = contentResolver.query(uri   // The content URI of the words table
                , null  //The columns to return for each row
                , null  //selection criteria
                , null  //Selection Criteria
                , null  //The sort order for the returned rows
        );
//        print number of contacts
        Log.d(TAG, "Total # of contacts ::: "+ cursor.getCount());

//        check if number of contact is more than 0
        if (cursor.getCount() > 0){
//            If there are contacts print them till end
            while (cursor.moveToNext()){
//                get contact name
                @SuppressLint("Range") String contactName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
//                get contact number
                @SuppressLint("Range") String contactNumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
//                print contact name and number
                Log.d(TAG, "Contact Name     :::   "+ contactName + "    Ph     :::    "+ contactNumber);
            }
        }
//        close the cursor when done
        cursor.close();
    }
}