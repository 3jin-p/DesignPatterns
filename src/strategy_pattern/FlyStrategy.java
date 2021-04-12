package strategy_pattern;

public class FlyStrategy implements MoveStrategy {

    @Override
    public void move() {
        System.out.println("Fly to the Sky!!");
    }
}
