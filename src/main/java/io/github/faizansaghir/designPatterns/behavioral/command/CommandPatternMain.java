package io.github.faizansaghir.designPatterns.behavioral.command;

public class CommandPatternMain {
    public static void main(String[] args) throws InterruptedException {
        EWSService service = new EWSService();
        Command c1 = new AddMemberCommand("a@a.com", "spam", service);
        MailTaskRunner.getInstance().addCommand(c1);

        Command c2 = new AddMemberCommand("b@b.com", "spam", service);
        MailTaskRunner.getInstance().addCommand(c2);

        Thread.sleep(3000);
        MailTaskRunner.getInstance().shutdown();
    }
}
