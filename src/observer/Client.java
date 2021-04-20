package observer;

public class Client {
    public static void main(String[] args) {
        Battery battery = Battery.newFullBattery();
        BatteryLevelDisplay batteryLevelDisplay = new BatteryLevelDisplay(battery);
        LowBatteryWarning lowBatteryWarning = new LowBatteryWarning(battery);
        battery.attach(batteryLevelDisplay);
        battery.attach(lowBatteryWarning);

        battery.consume(89);
        battery.consume(1);
    }
}
