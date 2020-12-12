package com.telysoft.react.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BTStateReceiver extends BroadcastReceiver {

    private RCTEventEmitter emitter;

    public BTStateReceiver(RCTEventEmitter emitter) {
        this.emitter = emitter;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        final String action = intent.getAction();

        if (BluetoothAdapter.ACTION_STATE_CHANGED.equals(action)) {
            final int state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, BluetoothAdapter.ERROR);
            switch (state) {
                case BluetoothAdapter.STATE_OFF:
                    Log.d(this.getClass().getSimpleName(), "Bluetooth was disabled");
                    emitter.sendEvent(BTEvent.BLUETOOTH_DISABLED.code, null);
                    break;
                case BluetoothAdapter.STATE_ON:
                    Log.d(this.getClass().getSimpleName(), "Bluetooth was enabled");
                    emitter.sendEvent(BTEvent.BLUETOOTH_ENABLED.code, null);
                    break;
            }
        }
    }
}
