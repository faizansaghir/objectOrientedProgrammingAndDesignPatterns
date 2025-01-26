package io.github.faizansaghir.designPatterns.structural.decorator;

import org.apache.commons.lang3.StringEscapeUtils;

public class HTMLEncodedMessage implements Message{
    private final Message message;

    public HTMLEncodedMessage(Message message) {
        this.message = message;
    }

    @Override
    public String getContent() {
        return StringEscapeUtils.escapeHtml4(message.getContent());
    }
}
