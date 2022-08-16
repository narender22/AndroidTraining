package com.example.dessertplace;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

/*
 * Main Activity
 * */
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivityLog";
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    /*
     * onCreate method
     * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        drawer layout instance to toggle the menu icon to open
//        drawer and back button to close drawer
        drawerLayout = findViewById(R.id.navDrawer);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

//        pass the open and close toggle for the drawer layout listener
//        to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

//        to make the navigation drawer icon always appear on the action bar
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

    }

    /*
     * To add menu is MainActivity
     * */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.dessertmenu, menu);
        return true;
    }

    /*
     * define menu click/select
     * */
    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        /*
         * item is the menu item that is clicked/selected
         * */
        switch (item.getItemId()) {
//            when shop icon is selected
            case R.id.shop:
                Toast.makeText(this, "Shop menu selected", Toast.LENGTH_SHORT).show();
                return true;
//          when info icon  is selected
            case R.id.info:
                Toast.makeText(this, "Info menu selected", Toast.LENGTH_SHORT).show();
                return true;
//            when favorites menu is selected
            case R.id.favorites:
                Toast.makeText(this, "Favorites menu selected", Toast.LENGTH_SHORT).show();
                return true;
//            when contact menu is selected
            case R.id.contact:
                Toast.makeText(this, "Contact menu selected", Toast.LENGTH_SHORT).show();
                return true;
//                if nothing is selected from menu
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /*
     * When user clicks on the submit button
     * */
    public void onSubmitClick(View view) {
        Log.d(TAG, "onSubmitClick: submit button clicked");
//        create an intent
        Intent intent = new Intent(this, SecondActivity.class);
//      create an instance of editText
        EditText editText = findViewById(R.id.personName);
//        convert the content in editText to string
        String personName = editText.getText().toString();
//        put personName in intent
        intent.putExtra("personName", personName);
        Log.d(TAG, "onSubmitClick: intent created");
//        send the intent to SecondActivity
        startActivity(intent);
        Log.d(TAG, "onSubmitClick: intent called");

    }
}