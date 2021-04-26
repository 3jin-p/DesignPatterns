package decorator;

public class TeamsMessageDecorator extends MessageDecorator {

    public TeamsMessageDecorator(MessageService decoratedMessageService) {
        super(decoratedMessageService);
    }

    @Override
    public void sendMessage() {
        super.sendMessage();
        sendTeamsMessage();
    }

    private void sendTeamsMessage() {
        System.out.println("팀즈 메시지 전소오오오옹");
    }
}
