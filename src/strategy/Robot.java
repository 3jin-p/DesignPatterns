package strategy;

public abstract class Robot {

    private String name;

    private MoveStrategy moveStrategy;

    private AttackStrategy attackStrategy;

    public Robot(String name) {
        this.name = name;
    }

    public void move() {
        moveStrategy.move();
    }

    public void attack() {
        attackStrategy.attack();
    }

    public void setMoveStrategy(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public void setAttackStrategy(AttackStrategy attackStrategy) {
        this.attackStrategy = attackStrategy;
    }
}
