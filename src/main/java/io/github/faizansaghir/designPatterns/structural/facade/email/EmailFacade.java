package io.github.faizansaghir.designPatterns.structural.facade.email;

public class EmailFacade {
    public boolean sendOrderEmail(Order order){
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
