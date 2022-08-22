package com.example.dessertplace;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

/*
 * Second Activity
 * */
public class SecondActivity extends AppCompatActivity {
    private static final String TAG = "SecondActivityLog";
    FloatingActionButton floatingActionButton;
    
    //    defining some variables to be used
    Intent intent2;
    Bundle bundle;
    String personName;
    /*
     * onCreate
     * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

//        setting the back button in the menu bar
//        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

//        creating instance of images
        ImageView image1 = findViewById(R.id.cakeImage);
        ImageView image2 = findViewById(R.id.donutsImage);
        ImageView image3 = findViewById(R.id.IceCreamImage);

//        register images for context menus
        registerForContextMenu(image1);
        registerForContextMenu(image2);
        registerForContextMenu(image3);

        Log.d(TAG, "onCreate: onCreate started");
        //    intent from SecondActivity to ThirdActivity
        intent2 = new Intent(this, ThirdActivity.class);
        //    bundle for second activity
        bundle = getIntent().getExtras();
        //    convert the intent content to string
        personName = bundle.getString("personName");

        Log.d(TAG, "onCreate: variable Instances created");
        /*
         * setting text view from MainActivity
         * */
        if (bundle != null) {
//            create an instance of textView
            Log.d(TAG, "onCreate: title changed");
            TextView textView = findViewById(R.id.title2);
            textView.setText(String.format("Hello %s", personName));
        }
        floatingActionButton = findViewById(R.id.floatingActionButton);
//        Floating action button - on click listener
        floatingActionButton.setOnClickListener(view ->
                Toast.makeText(SecondActivity.this, "Floating action button clicked", Toast.LENGTH_SHORT).show());
    }

    /*
    * When image is long clicked context menu will pop up
    * attack context menu to activity
    * */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Choose an option: ");
        getMenuInflater().inflate(R.menu.contextmenu, menu);
    }

//    define working of options of context menu
    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
//            for edit option
            case R.id.edit:
                Toast.makeText(this, "Edit context selected", Toast.LENGTH_SHORT).show();
                return true;
//                for share option
            case R.id.share:
                Toast.makeText(this, "Share context selected", Toast.LENGTH_SHORT).show();
                return true;
//                for delete option
            case R.id.delete:
                Toast.makeText(this, "Delete context selected", Toast.LENGTH_SHORT).show();
                return true;
//                if no option is selected do nothing
            default:
                return super.onContextItemSelected(item);
        }
    }

    /*
     * When cake image is clicked
     * personName and dessert name will be sent
     * */
    public void onCakeClick(View view) {
        Log.d(TAG, "onCakeClick: Cake image clicked");
        intent2.putExtra("order", "cake");
        intent2.putExtra("personName", personName);
        startActivity(intent2);
    }

    /*
     * When Ice Cream image is clicked
     * personName and dessert name will be sent
     * */
    public void onIceCreamClick(View view) {
        Log.d(TAG, "onIceCreamClick: Ice cream image clicked");
        intent2.putExtra("order", "Ice Cream");
        intent2.putExtra("personName", personName);
        startActivity(intent2);
    }

    /*
     * When Donut image is clicked
     * personName and dessert name will be sent
     * */
    public void onDonutClick(View view) {
        Log.d(TAG, "onDonutClick: Donut image clicked");
        intent2.putExtra("order", "Donut");
        intent2.putExtra("personName", personName);
        startActivity(intent2);
    }
}