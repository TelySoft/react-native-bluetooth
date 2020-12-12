package com.telysoft.react.bluetooth;

import android.bluetooth.BluetoothDevice;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;

import java.util.HashMap;
import java.util.Map;

public class BTDevice {

    private BluetoothDevice device;
    private Map<String,Object> extra;

    public BTDevice(BluetoothDevice device) {
        this.device = device;
        this.extra = new HashMap<String,Object>();
    }

    public BluetoothDevice getDevice() {
        return device;
    }

    public void addExtra(String name, Object value) {
        extra.put(name, value);
    }

    public <T> T getExtra(String name) {
        return (T) extra.get(name);
    }

    public WritableMap map() {
        if (device == null)
            return null;

        WritableMap map = Arguments.createMap();

        map.putString("name", device.getName());
        map.putString("address", device.getAddress());
        map.putString("id", device.getAddress());
        map.putInt("class", (device.getBluetoothClass() != null)
                ? device.getBluetoothClass().getDeviceClass() : -1);

        map.putArray("extra", Arguments.fromArray(extra));

        return map;
    }
}
