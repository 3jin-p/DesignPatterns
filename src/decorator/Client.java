package decorator;

public class Client {
    public static void main(String[] args) {
        MessageService mailMessaging = new BasicMessageService();
        mailMessaging.sendMessage(); // 메일 전송

        MessageService slackMessaging = new SlackMessageDecorator(new BasicMessageService());
        slackMessaging.sendMessage(); // 메일 전송, 슬랙 전송

        MessageService teamsMessaging = new TeamsMessageDecorator(new BasicMessageService());
        teamsMessaging.sendMessage(); // 메일전송, 팀즈 전송

        MessageService slackAndTeamsAndMailMessaging
                = new SlackMessageDecorator(new TeamsMessageDecorator(new BasicMessageService()));
        slackAndTeamsAndMailMessaging.sendMessage(); // 메일전송, 팀즈전송, 슬랙전송
    }
}
