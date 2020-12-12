
# @telysoft/react-native-bluetooth

## Getting started

`$ npm install @telysoft/react-native-bluetooth --save`

### Mostly automatic installation

`$ react-native link @telysoft/react-native-bluetooth`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `@telysoft/react-native-bluetooth` and add `RNTelysoftBluetooth.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNTelysoftBluetooth.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNTelysoftBluetoothPackage;` to the imports at the top of the file
  - Add `new RNTelysoftBluetoothPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':@telysoft/react-native-bluetooth'
  	project(':@telysoft/react-native-bluetooth').projectDir = new File(rootProject.projectDir, 	'../node_modules/@telysoft/react-native-bluetooth/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':@telysoft/react-native-bluetooth')
  	```

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNTelysoftBluetooth.sln` in `node_modules/@telysoft/react-native-bluetooth/windows/RNTelysoftBluetooth.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Telysoft.Bluetooth.RNTelysoftBluetooth;` to the usings at the top of the file
  - Add `new RNTelysoftBluetoothPackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNTelysoftBluetooth from '@telysoft/react-native-bluetooth';

// TODO: What to do with the module?
RNTelysoftBluetooth;
```
  