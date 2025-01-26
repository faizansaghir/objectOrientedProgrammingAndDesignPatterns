package io.github.faizansaghir.designPatterns.structural.decorator;

import java.util.Base64;

public class Base64EncodedMessage implements Message{
    private final Message message;

    public Base64EncodedMessage(Message message) {
        this.message = message;
    }

    @Override
    public String getContent() {
        return Base64.getEncoder().encodeToString(message.getContent().getBytes());
    }
}
