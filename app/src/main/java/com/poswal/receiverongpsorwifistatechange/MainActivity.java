package com.poswal.receiverongpsorwifistatechange;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private MyReceiver myReceiver;
    private TextView textView;
    private static Bundle savedInstanceState;
    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.savedInstanceState = savedInstanceState;
        super.onCreate(savedInstanceState);
        context = MainActivity.this;
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textview);
        myReceiver = new MyReceiver(MainActivity.this);
        final IntentFilter filters = new IntentFilter();
        filters.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        filters.addAction("android.net.wifi.STATE_CHANGE");
        filters.addAction("android.net.conn.CONNECTIVITY_CHANG");
        filters.addAction("android.location.PROVIDERS_CHANGED");
        super.registerReceiver(myReceiver, filters);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String msg = bundle.getString("Update");
            textView.setText(msg);
        }


    }

    @Override
    protected void onResume() {
        super.onResume();
        unregisterReceiver(myReceiver);
    }

    private void showToast(String msg) {
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    public static void update() {
        Toast.makeText(context, "Update", Toast.LENGTH_SHORT).show();

    }

}
