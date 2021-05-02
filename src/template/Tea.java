package template;

public class Tea extends Drink {
    @Override
    void putPowder() {
        System.out.println("티백 퐁당");
    }

    @Override
    protected void pourToCup() {
        System.out.println("티 잔에");
        super.pourToCup();
    }
}
