package strategy;

public class FlyStrategy implements MoveStrategy {

    @Override
    public void move() {
        System.out.println("Fly to the Sky!!");
    }
}
