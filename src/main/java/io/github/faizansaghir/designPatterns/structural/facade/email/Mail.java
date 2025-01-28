package io.github.faizansaghir.designPatterns.structural.facade.email;

public class Mail {
    public static Mailer getMailer() {
        return new Mailer();
    }
}
