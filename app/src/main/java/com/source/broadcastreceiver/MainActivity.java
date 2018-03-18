package com.source.broadcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    ConnectionReceiver receiver;
    IntentFilter intentFilter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        receiver = new ConnectionReceiver();
        intentFilter = new IntentFilter("com.syntaxt.broadcastreceiver.SOME_ACTION");

    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(receiver, intentFilter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }//this fuf


    public void someMethod(View view) {
        Intent intent = new Intent("com.syntaxt.broadcastreceiver.SOME_ACTION");
        sendBroadcast(intent);
    }

    private void doTask() {
        // to do task
    }
}
