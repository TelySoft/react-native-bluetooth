package com.telysoft.react.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.facebook.react.BuildConfig;


public class BTConnectionReceiver extends BroadcastReceiver {

    private RCTEventEmitter emitter;

    public BTConnectionReceiver(RCTEventEmitter emitter) {
        this.emitter = emitter;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        final String action = intent.getAction();

        if (BuildConfig.DEBUG)
            Log.d(this.getClass().getSimpleName(), "onReceive action: " + action);

        if (BluetoothDevice.ACTION_ACL_DISCONNECT_REQUESTED.equals(action)) {
            final BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
            Log.d(this.getClass().getSimpleName(), "Device connected: " + device.toString());
            emitter.sendEvent(BTEvent.BLUETOOTH_DISCONNECTED.code,
                    new BTDevice(device).map());
        }
    }
}
