package io.github.faizansaghir.designPatterns.memento;

public class CreateCommand extends AbstractWorkflowCommand{
    private final String name;
    public CreateCommand(String name, WorkflowDesigner receiver) {
        super(receiver);
        this.name = name;
    }

    @Override
    public void execute() {
        this.memento = receiver.getMemento();
        receiver.createWorkflow(name);
    }
}
