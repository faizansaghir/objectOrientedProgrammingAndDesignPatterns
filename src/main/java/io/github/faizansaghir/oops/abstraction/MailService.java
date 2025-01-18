package io.github.faizansaghir.oops.abstraction;

public class MailService {
    public void sendEmail() {
        connect();
        authenticate();
        disconnect();
    }
    private void connect() {
        System.out.println("Connected");
    }
    private void disconnect() {
        System.out.println("Disconnected");
    }
    private void authenticate() {
        System.out.println("Authenticated");
    }

}
