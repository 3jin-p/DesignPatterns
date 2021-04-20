package observer;

public class Battery extends Subject {

    private int level = 100;

    public void consume(int amount) {
        this.level -= amount;
        notifyObservers();
    }

    public int getLevel() {
        return level;
    }

    public static Battery newFullBattery() {
        return new Battery();
    }

    private Battery() {}
}
