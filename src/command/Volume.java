package command;

public class Volume {

    private int volume = 0;

    public static Volume createZeroVolume() {
        return new Volume();
    }

    public void volumeUp() {
        this.volume += 1;
    }
}
