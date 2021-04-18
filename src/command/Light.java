package command;

public class Light {

    boolean isOn = false;

    public static Light createOffedLight() {
        return new Light();
    }

    public void lightOn() {
        System.out.println("light On");
    }
}
