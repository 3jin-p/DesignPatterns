package observer;

public class LowBatteryWarning implements Observer {

    private Battery battery;
    private final int ALERT_LEVEL = 10;

    @Override
    public void update() {
        alert();
    }

    private void alert() {
        if (isBatteryReachedAlertLevel()) {
            System.out.println("Warning -- Low Battery!");
        }
    }

    private boolean isBatteryReachedAlertLevel() {
        return battery.getLevel() <= ALERT_LEVEL;
    }

    public LowBatteryWarning(Battery battery) {
        this.battery = battery;
    }
}
