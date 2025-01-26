package io.github.faizansaghir.designPatterns.structural.decorator;

public class DecoratorMain {
    public static void main(String[] args) {
        Message message = new TextMessage("The <FORCE> is strong with this one!");
        System.out.println(message.getContent());

        Message decorator = new HTMLEncodedMessage(message);
        System.out.println(decorator.getContent());

        decorator = new Base64EncodedMessage(decorator);
        System.out.println(decorator.getContent());
    }
}
