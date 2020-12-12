import Foundation

/**
 Provides standard object for messaging using the React bridge.  Generic classes
 cannot be used or exported with @objc therefore we need the asDictionary function
 in order to control conversion.
 
 This has been tested with <String> but will
 probably need some love in order to get other objects working based on the
 implementation.  If anything changes, it will most likely be the building
 of the dictionary to appropriately convert the data object into a String
 (or other basic React Bridge serializable object)
 */
class BTMessage<T> : NSObject {
    
    public private(set) var device:BTDevice
    public private(set) var data:T
    public private(set) var timestamp:Date
    
    init(fromDevice:BTDevice, data:T) {
        self.device = fromDevice
        self.data = data
        self.timestamp = Date()
    }
    
    func asDictionary() -> Dictionary<String,Any> {
        return [
            "device": device.asDictionary(),
            "data": data,
            "timestamp": timestamp
        ]
    }
}
