package observer;

public class BatteryLevelDisplay implements Observer {

    private Battery battery;

    @Override
    public void update() {
        display();
    }

    private void display() {
        System.out.println(battery.getLevel());
    }

    public BatteryLevelDisplay(Battery battery) {
        this.battery = battery;
    }
}
