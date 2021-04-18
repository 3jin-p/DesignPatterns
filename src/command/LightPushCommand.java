package command;

public class LightPushCommand implements PushCommand {

    private Light light;

    public LightPushCommand(Light light) {
        this.light = light;
    }

    @Override
    public void push() {
        light.lightOn();
    }
}
