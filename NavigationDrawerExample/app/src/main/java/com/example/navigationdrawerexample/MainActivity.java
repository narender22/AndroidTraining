package com.example.navigationdrawerexample;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
/*
* Main activity
* */
public class MainActivity extends AppCompatActivity {
//    create an instance of views to be used
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
/*
* When app is created
* */
    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        set view id for instances
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navView);
        toolbar = findViewById(R.id.toolBar);

//        set tool bar
        setSupportActionBar(toolbar);

//        set action for app drawer
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
//        set listener for drawer
        drawerLayout.addDrawerListener(toggle);

//        sync drawer according to action
        toggle.syncState();

//        set the task to be performed on click of some button/view in app drawer
        navigationView.setNavigationItemSelectedListener(item -> {
            switch (item.getItemId()){
//                when home button is clicked
                case R.id.home:
//                    show a toast
                    Toast.makeText(MainActivity.this, "Home button clicked", Toast.LENGTH_SHORT).show();
//                    close the drawer when clicked
                    drawerLayout.closeDrawer(GravityCompat.START);
//                when call button is clicked
                case R.id.call:
                    Toast.makeText(MainActivity.this, "Home button clicked", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
//                on setting button click
                case R.id.setting:
                    Toast.makeText(MainActivity.this, "Home button clicked", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                default:
                    drawerLayout.closeDrawer(GravityCompat.START);
            }

            return true;
        });
    }
/*
* If user presses the back button
* */
    @Override
    public void onBackPressed() {
//        check if drawer is open or not
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
//            if drawer is open close it
            drawerLayout.closeDrawer(GravityCompat.START);
        }
//        is drawer is not open do default set task
        else{
            super.onBackPressed();
        }
    }
}