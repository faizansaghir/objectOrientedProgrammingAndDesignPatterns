package io.github.faizansaghir.designPatterns.behavioral.command;

public class AddMemberCommand implements Command{
    private final String emailAddress;
    private final String listName;
    private final EWSService service;

    public AddMemberCommand(String emailAddress, String listName, EWSService service) {
        this.emailAddress = emailAddress;
        this.listName = listName;
        this.service = service;
    }

    @Override
    public void execute() {
        service.addMember(emailAddress, listName);
    }
}
