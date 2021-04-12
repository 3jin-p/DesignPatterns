package strategy_pattern;

public class RunStrategy implements MoveStrategy {
    @Override
    public void move() {
        System.out.println("Run Run Faster!");
    }
}
