// Define the SmartDevice class
open class SmartDevice(
    val name: String,
    val category: String,
    val deviceType: String,
    var deviceStatus: String = "off"
) {
    var deviceTurnOnCount: Int = 0

    fun turnOn() {
        if (deviceStatus == "off") {
            deviceStatus = "on"
            deviceTurnOnCount++
        }
    }

    fun turnOff() {
        if (deviceStatus == "on") {
            deviceStatus = "off"
        }
    }

    fun printDeviceInfo() {
        println("Device name: $name, category: $category, type: $deviceType")
    }
}

// Define the SmartTvDevice class
class SmartTvDevice(
    name: String,
    category: String,
    deviceType: String
) : SmartDevice(name, category, deviceType) {

    var volume: Int = 50
    var channel: Int = 1

    fun decreaseVolume() {
        if (deviceStatus == "on") {
            if (volume > 0) {
                volume--
                println("Decreased TV volume to $volume")
            }
        }
    }

    fun previousChannel() {
        if (deviceStatus == "on") {
            if (channel > 1) {
                channel--
                println("Changed TV channel to $channel")
            }
        }
    }
}

// Define the SmartLightDevice class
class SmartLightDevice(
    name: String,
    category: String,
    deviceType: String
) : SmartDevice(name, category, deviceType) {

    var brightness: Int = 100

    fun decreaseBrightness() {
        if (deviceStatus == "on") {
            if (brightness > 0) {
                brightness--
                println("Decreased light brightness to $brightness")
            }
        }
    }
}

// Define the SmartHome class
class SmartHome {
    var smartTvDevice = SmartTvDevice("Living Room TV", "Entertainment", "Smart TV")
    var smartLightDevice = SmartLightDevice("Living Room Light", "Home Automation", "Smart Light")

    fun decreaseTvVolume() {
        smartTvDevice.decreaseVolume()
    }

    fun changeTvChannelToPrevious() {
        smartTvDevice.previousChannel()
    }

    fun printSmartTvInfo() {
        smartTvDevice.printDeviceInfo()
    }

    fun printSmartLightInfo() {
        smartLightDevice.printDeviceInfo()
    }

    fun decreaseLightBrightness() {
        smartLightDevice.decreaseBrightness()
    }
}

// Main function to test the implementation
fun main() {
    val smartHome = SmartHome()

    // Test SmartTvDevice methods
    smartHome.smartTvDevice.turnOn()
    smartHome.decreaseTvVolume()
    smartHome.changeTvChannelToPrevious()
    smartHome.printSmartTvInfo()

    // Test SmartLightDevice methods
    smartHome.smartLightDevice.turnOn()
    smartHome.decreaseLightBrightness()
    smartHome.printSmartLightInfo()
}
