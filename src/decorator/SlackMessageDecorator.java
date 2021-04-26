package decorator;

public class SlackMessageDecorator extends MessageDecorator {

    public SlackMessageDecorator(MessageService decoratedMessageService) {
        super(decoratedMessageService);
    }

    @Override
    public void sendMessage() {
        super.sendMessage();
        sendSlackMessage();
    }

    private void sendSlackMessage() {
        System.out.println("슬랙 메시지 전송!!!!!");
    }
}
