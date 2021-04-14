package state;

public class OffState implements LightState{

    private static OffState offState = null;

    private OffState() {}

    public static OffState getInstance() {
        if (offState == null) {
            offState = new OffState();
        }
        return offState;
    }

    @Override
    public void turnOnButtonPushed(Light light) {
        light.setState(OnState.getInstance());
        System.out.println("불 켜짐");
    }

    @Override
    public void turnOffButtonPushed(Light light) {
        System.out.println("변화 없음");
    }
}
