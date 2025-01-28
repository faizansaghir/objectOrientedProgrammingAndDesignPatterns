package io.github.faizansaghir.designPatterns.structural.facade;

import io.github.faizansaghir.designPatterns.structural.facade.email.*;

public class FacadePatternMain {
    public static void main(String[] args) {
        Order order = new Order("101", 99.99);

        boolean result = sendOrderEmailWithoutFacade(order);

        System.out.println("Order Email "+(result?"Sent Successfully":"Send Failed"));

        EmailFacade emailFacade = new EmailFacade();
        result = emailFacade.sendOrderEmail(order);

        System.out.println("Order Email "+(result?"Sent Successfully":"Send Failed"));
    }
    private static boolean sendOrderEmailWithoutFacade(Order order){
        Template template = TemplateFactory.createTemplateFor(TemplateType.Email);
        Stationary stationary = StationaryFactory.createStationary();
        Email email = Email.getBuilder()
                .withTemplate(template)
                .withStationary(stationary)
                .forObject(order)
                .build();
        Mailer mailer = Mail.getMailer();
        return mailer.send(email);
    }
}
