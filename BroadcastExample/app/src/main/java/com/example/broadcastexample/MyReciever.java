package com.example.broadcastexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReciever extends BroadcastReceiver {

    private static final String TAG = "Broadcast";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: broadcast called");
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        /*
        * Toast to verify call
        * */
        Toast.makeText(context, "Intent for Broadcast fired", Toast.LENGTH_SHORT).show();
    }
}