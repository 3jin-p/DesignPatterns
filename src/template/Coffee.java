package template;

public class Coffee extends Drink {
    @Override
    void putPowder() {
        System.out.println("커피 가루 콸ㅋ콸콸~");
    }

    @Override
    protected void pourToCup() {
        System.out.println("커피잔에");
        super.pourToCup();
    }
}
