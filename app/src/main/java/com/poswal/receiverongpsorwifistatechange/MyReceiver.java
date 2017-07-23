package com.poswal.receiverongpsorwifistatechange;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by komal on 23-07-2017.
 */

public class MyReceiver extends BroadcastReceiver {
    private Context con;

    MyReceiver() {
    }

    MyReceiver(Context context) {
        con = context;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        if (action.equals("android.net.wifi.WIFI_STATE_CHANGED")) {
            Toast.makeText(context, "WIFI_STATE_CHANGED", Toast.LENGTH_SHORT).show();
            MainActivity.update();

        } else if (action.equals("android.location.PROVIDERS_CHANGED")) {
            Toast.makeText(context, "PROVIDERS_CHANGED", Toast.LENGTH_SHORT).show();
        } else if (action.equals("android.net.wifi.STATE_CHANGE")) {
            Toast.makeText(context, "STATE_CHANGE", Toast.LENGTH_SHORT).show();
        } else if (action.equals("android.net.conn.CONNECTIVITY_CHANG")) {
            Toast.makeText(context, "CONNECTIVITY_CHANG", Toast.LENGTH_SHORT).show();
        }

    }
}
