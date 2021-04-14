package state;

public class OnState implements LightState{

    private static OnState onState = null;

    private OnState() {}

    public static OnState getInstance() {
        if (onState == null) {
            onState = new OnState();
        }
        return onState;
    }

    @Override
    public void turnOnButtonPushed(Light light) {
        System.out.println("변화 없음");
    }

    @Override
    public void turnOffButtonPushed(Light light) {
        light.setState(OffState.getInstance());
        System.out.println("불 꺼짐");
    }
}
