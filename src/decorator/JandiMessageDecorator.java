package decorator;

public class JandiMessageDecorator extends MessageDecorator {

    public JandiMessageDecorator(MessageService decoratedMessageService) {
        super(decoratedMessageService);
    }

    @Override
    public void sendMessage() {
        super.sendMessage();
        sendJandiMessage();
    }

    private void sendJandiMessage() {
        System.out.println("잔디 메시지 전소옹");
    }
}
