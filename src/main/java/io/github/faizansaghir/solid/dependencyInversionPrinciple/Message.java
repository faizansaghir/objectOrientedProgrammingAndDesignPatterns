package io.github.faizansaghir.solid.dependencyInversionPrinciple;

import java.time.LocalDateTime;

public class Message {
    private final String messageBody;
    private final String timestamp;

    public Message(String messageBody) {
        this.messageBody = messageBody;
        this.timestamp = LocalDateTime.now().toString();
    }

    public String getMessageBody() {
        return messageBody;
    }

    public String getTimestamp() {
        return timestamp;
    }

}
