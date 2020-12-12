
package com.telysoft.react.bluetooth;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.bridge.JavaScriptModule;

/**
 * Registers the RNTelySoftBluetoothModule with ReactNative.  The package is used to configure the
 * module, currently it takes no input and passes through the
 * {@link com.facebook.react.bridge.ReactContext}.
 * <p>
 * There are no ViewManagers provided with this Module.
 *
 * @author telysoft
 *
 */
public class RNTelySoftBluetoothPackage implements ReactPackage {

    private String delimiter;
    private Charset charset;

    public RNTelySoftBluetoothPackage(String delimiter, Charset charset) {
        this.delimiter = delimiter;
        this.charset = charset;
    }

    public RNTelySoftBluetoothPackage() {
        this("\n", CommonCharsets.LATIN.charset());
    }

    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
      return Arrays.<NativeModule>asList(new RNTelySoftBluetoothModule(reactContext, delimiter, charset));
    }

    // Deprecated from RN 0.47
    public List<Class<? extends JavaScriptModule>> createJSModules() {
      return Collections.emptyList();
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
      return Collections.emptyList();
    }

}