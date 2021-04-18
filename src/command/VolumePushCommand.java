package command;

public class VolumePushCommand implements PushCommand {

    private Volume volume;

    public VolumePushCommand(Volume volume) {
        this.volume = volume;
    }

    @Override
    public void push() {
        volume.volumeUp();
    }
}
