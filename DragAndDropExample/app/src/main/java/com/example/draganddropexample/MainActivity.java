package com.example.draganddropexample;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    float xCoOrdinate, yCoOrdinate;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        define image view and assign image view
        ImageView imageView = findViewById(R.id.image);

//        when imageview is touched
        imageView.setOnTouchListener((view, motionEvent) -> {
            onViewTouch(view, motionEvent);
            return true;
        });
    }

    private void onViewTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()){
//            when image view is held/grabbed
            case MotionEvent.ACTION_DOWN:
//                get the coordinates of the image where touched
                xCoOrdinate = view.getX() - motionEvent.getRawX();
                yCoOrdinate = view.getY() - motionEvent.getRawY();
                break;
//            when image is left/released
            case MotionEvent.ACTION_UP:
//                change the coordinates of the image when released
                view.animate().x(motionEvent.getRawX() + xCoOrdinate).y(motionEvent.getRawY() + yCoOrdinate).setDuration(0).start();
                break;
        }
    }
}