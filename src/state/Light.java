package state;

public class Light {

    private LightState state;

    public Light() {
        this.state = OffState.getInstance();
    }

    public void setState(LightState state) {
        this.state = state;
    }

    public void onButtonPush() {
        state.turnOnButtonPushed(this);
    }

    public void offButtonPust() {
        state.turnOffButtonPushed(this);
    }
}
