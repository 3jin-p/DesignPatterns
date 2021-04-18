package command;

public class Button {

    private PushCommand pushCommand;

    public Button() {}

    public Button(PushCommand pushCommand) {
        this.pushCommand = pushCommand;
    }

    public void push() {
        pushCommand.push();
    }

    public void setPushCommand(PushCommand pushCommand) {
        this.pushCommand = pushCommand;
    }
}
