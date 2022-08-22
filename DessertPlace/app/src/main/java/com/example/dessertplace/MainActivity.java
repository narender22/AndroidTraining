package com.example.dessertplace;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;


/*
 * Main Activity
 * */
public class MainActivity extends AppCompatActivity {
    //    create an instance of views to be used
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

//    notification variables
    private static final String CHANNEL_ID =  "Message channel";
    private static final int NOTIFICATION_ID =  100;

    /*
     * onCreate method
     * */
    @RequiresApi(api = Build.VERSION_CODES.M)
    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        set view id for instances
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navView);
        toolbar = findViewById(R.id.toolBar);

        loadFragment(new MainFragment());

//        set tool bar
        setSupportActionBar(toolbar);

//        set action for app drawer
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_open, R.string.nav_close);
//        set listener for drawer
        drawerLayout.addDrawerListener(toggle);

//        sync drawer according to action
        toggle.syncState();

//        set the task to be performed on click of some button/view in app drawer
        navigationView.setNavigationItemSelectedListener(item -> {
            switch (item.getItemId()){
//                when account menu is clicked from drawer
                case R.id.account:
//                    show a toast
                    Toast.makeText(MainActivity.this, "account button clicked", Toast.LENGTH_SHORT).show();
//                    close the drawer when clicked
                    drawerLayout.closeDrawer(GravityCompat.START);
//                when setting menu is clicked from drawer
                case R.id.setting:
                    Toast.makeText(MainActivity.this, "setting button clicked", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
//                when contact us menu is clicked from drawer
                case R.id.contactUs:
                    Intent callCare = new Intent(Intent.ACTION_DIAL);
                    callCare.setData(Uri.parse("tel: 1800111222"));
                    startActivity(callCare);
                    drawerLayout.closeDrawer(GravityCompat.START);
//                on logOut menu is clicked from drawer
                case R.id.logOut:
                    logoutNotify();
                    drawerLayout.closeDrawer(GravityCompat.START);
                default:
                    drawerLayout.closeDrawer(GravityCompat.START);
            }
            return true;
        });
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.add(R.id.container, fragment);
        ft.commit();

    }

    /*
    * If the user press back button
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

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void logoutNotify() {
        //        get a drawable
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.android_logo, null);
//        convert drawable to bitmap drawable
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        assert bitmapDrawable != null;
        Bitmap largeIcon = bitmapDrawable.getBitmap();

//        set notification manager
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification;

//        set intent for pending notification
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

//        set pendingIntent for notification click
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 100, intent, PendingIntent.FLAG_IMMUTABLE);

//        check if android version is > 11
//        and set the no
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            notification = new NotificationCompat.Builder(MainActivity.this, CHANNEL_ID)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.android_logo)
                    .setContentIntent(pendingIntent)
                    .setContentText("User has successfully logged out")
                    .setSubText("Logout")
                    .build();
            nm.createNotificationChannel(new NotificationChannel(CHANNEL_ID, "Message Channel", NotificationManager.IMPORTANCE_DEFAULT));
        }
        else{
            notification = new Notification.Builder(MainActivity.this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.android_logo)
                    .setContentIntent(pendingIntent)
                    .setContentText("User has successfully logged out")
                    .setSubText("Logout")
                    .build();
        }
//        send notification
        nm.notify(NOTIFICATION_ID, notification);

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

}