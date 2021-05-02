
package template;

public abstract class Drink {

    public final void makeDrink() {
        boidWater();
        putPowder();
        mix();
        pourToCup();
    }

    private void boidWater() {
        System.out.println("보글보글");
    }

    abstract void putPowder();

    private void mix() {
        System.out.println("쉐낏 쉐낏");
    }

    protected void pourToCup() {
        System.out.println("쪼로록");
    }

}
