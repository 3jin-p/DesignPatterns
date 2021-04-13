package strategy;

public class Client {

    public static void main(String[] args) {
        Robot sungard = new SungardRobot("SunGard");
        Robot atom = new AtomRobot("Atom");

        sungard.setAttackStrategy(new MissileStrategy());
        sungard.setMoveStrategy(new FlyStrategy());

        atom.setAttackStrategy(new PunchStrategy());
        atom.setMoveStrategy(new RunStrategy());

        sungard.attack();
        atom.attack();

        sungard.move();
        atom.move();
    }
}
