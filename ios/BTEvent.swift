//
//  BTEvent.swift
//  RNTelySoftBluetooth

import Foundation

enum BTEvent : String, CaseIterable {
    case BLUETOOTH_ENABLED = "bluetoothEnabled"
    case BLUETOOTH_DISABLED = "bluetoothDisabled"
    case BLUETOOTH_CONNECTED = "bluetoothConnected"
    case BLUETOOTH_DISCONNECTED = "bluetoothDisconnected"
    case CONNECTION_SUCCESS = "connectionSuccess"        // Promise only
    case CONNECTION_FAILED = "connectionFailed"          // Promise only
    case CONNECTION_LOST = "connectionLost"
    case READ = "read"
    case ERROR = "error"
    
    static func asDictionary() -> NSDictionary {
        let events:NSDictionary = NSMutableDictionary()
        
        for event in BTEvent.allCases {
            events.setValue(event.rawValue, forKey: "\(event)")
        }
        
        return events
    }
    
    static func asArray() -> [String] {
        var events:[String] = [String]()
        
        for event in BTEvent.allCases {
            events.append(event.rawValue)
        }
        
        return events;
    }
}
