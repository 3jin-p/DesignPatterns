package command;

public class Client {
    public static void main(String[] args) {
        // This Button can Anything !
        Button anythingToDoButton = new Button();
        PushCommand pushCommandLight = new LightPushCommand(Light.createOffedLight());
        PushCommand pushCommandVolume = new VolumePushCommand(Volume.createZeroVolume());

        anythingToDoButton.setPushCommand(pushCommandLight);
        // Light On
        anythingToDoButton.push();

        anythingToDoButton.setPushCommand(pushCommandVolume);
        // Volume Up
        anythingToDoButton.push();
    }
}
