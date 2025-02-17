package io.github.faizansaghir.designPatterns.memento;

public interface WorkflowCommand {
    void execute();
    void undo();
}
