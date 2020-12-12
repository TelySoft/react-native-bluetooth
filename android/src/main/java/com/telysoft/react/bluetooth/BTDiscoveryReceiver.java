package com.telysoft.react.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.facebook.react.BuildConfig;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class BTDiscoveryReceiver extends BroadcastReceiver {

    private DiscoveryCompleteListener onComplete;
    private Map<String,BTDevice> unpairedDevices;

    public BTDiscoveryReceiver(DiscoveryCompleteListener listener) {
        this.onComplete = listener;
        this.unpairedDevices = new HashMap<>();
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        if (BluetoothDevice.ACTION_FOUND.equals(action)) {
            BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
            BTDevice btDevice = new BTDevice(device);
            btDevice.addExtra("name", intent.getStringExtra(BluetoothDevice.EXTRA_NAME));
            btDevice.addExtra("rssi", intent.getShortExtra(BluetoothDevice.EXTRA_RSSI, Short.MIN_VALUE));

            if (!unpairedDevices.containsKey(device.getAddress())) {
                if (BuildConfig.DEBUG)
                    Log.d(this.getClass().getSimpleName(), "onReceive found: " + btDevice);

                unpairedDevices.put(device.getAddress(), btDevice);
            } else {
                unpairedDevices.get(device.getAddress()).addExtra("rssi",
                        intent.getShortExtra(BluetoothDevice.EXTRA_RSSI, Short.MIN_VALUE));
            }
        } else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)) {
            onComplete.onDiscoveryComplete(unpairedDevices.values());
        }
    }

    public interface DiscoveryCompleteListener {
        void onDiscoveryComplete(Collection<BTDevice> unpairedDevices);
    }
}
