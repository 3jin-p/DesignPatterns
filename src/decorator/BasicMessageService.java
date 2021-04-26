package decorator;

public class BasicMessageService extends MessageService {
    @Override
    public void sendMessage() {
        System.out.println("기본 메시징 (메일을 보내~ ) 삐리링~");
    }
}
