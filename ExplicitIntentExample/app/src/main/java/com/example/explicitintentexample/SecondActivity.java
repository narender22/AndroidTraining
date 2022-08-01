package com.example.explicitintentexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

/*
* Second main Activity
* */
public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        /* get the image index from the intent */
        Bundle bundle = getIntent().getExtras();

        /*
        * If the index passed is correct then pass it to function to show the image
        * */
        if (bundle != null){
            String imgIndex = bundle.getString("imageIndex");
            setImage(imgIndex);
        }
    }
/*
* Function to set image when an an index is passed
* */
    private void setImage(String index) {
        ImageView imgView = findViewById(R.id.imageView);

        switch (index) {
            case "1":
                imgView.setImageResource(R.drawable.android_1);
                break;

            case "2":
                imgView.setImageResource(R.drawable.android_2);
                break;

            case "3":
                imgView.setImageResource(R.drawable.android_3);
                break;

            case "4":
                imgView.setImageResource(R.drawable.android_4);
                break;

            case "5":
                imgView.setImageResource(R.drawable.android_5);
                break;

            case "6":
                imgView.setImageResource(R.drawable.android_6);
                break;

            case "7":
                imgView.setImageResource(R.drawable.android_7);
                break;

            case "8":
                imgView.setImageResource(R.drawable.android_8);
                break;

            case "9":
                imgView.setImageResource(R.drawable.android_9);
                break;

            case "10":
                imgView.setImageResource(R.drawable.android_10);
                break;

            default:
                imgView.setImageResource(R.drawable.android_11);
                break;
        }
    }
}