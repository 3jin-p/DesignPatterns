package strategy_pattern;

public class MissileStrategy implements AttackStrategy {
    @Override
    public void attack() {
        System.out.println("Lunch Missile !! ~ssss");
    }
}
