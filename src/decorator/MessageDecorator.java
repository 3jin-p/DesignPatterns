package decorator;

public abstract class MessageDecorator extends MessageService {

    private MessageService decoratedMessageService;

    public MessageDecorator(MessageService decoratedMessageService) {
        this.decoratedMessageService = decoratedMessageService;
    }

    @Override
    public void sendMessage() {
        decoratedMessageService.sendMessage();
    }
}
