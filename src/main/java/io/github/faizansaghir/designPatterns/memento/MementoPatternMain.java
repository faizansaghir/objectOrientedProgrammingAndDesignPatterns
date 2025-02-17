package io.github.faizansaghir.designPatterns.memento;

import java.util.LinkedList;

public class MementoPatternMain {
    public static void main(String[] args) {
        WorkflowDesigner designer = new WorkflowDesigner();
        LinkedList<WorkflowCommand> commands = runCommands(designer);
        designer.print();
        undoLastCommand(commands);
        designer.print();
        undoLastCommand(commands);
        designer.print();
        undoLastCommand(commands);
        designer.print();
        undoLastCommand(commands);
        designer.print();
        undoLastCommand(commands);
        designer.print();
    }
    private static void undoLastCommand(LinkedList<WorkflowCommand> commands) {
        if(!commands.isEmpty()){
            commands.removeLast().undo();
        }
    }
    private static LinkedList<WorkflowCommand> runCommands(WorkflowDesigner designer) {
        LinkedList<WorkflowCommand> commands = new LinkedList<>();

        WorkflowCommand cmd = new CreateCommand("Leave Workflow", designer);
        commands.addLast(cmd);
        cmd.execute();

        designer.print();

        cmd = new AddStepCommand(designer, "Create Leave Application");
        commands.addLast(cmd);
        cmd.execute();

        cmd = new AddStepCommand(designer, "Submit Application");
        commands.addLast(cmd);
        cmd.execute();

        cmd = new AddStepCommand(designer, "Application Approved");
        commands.addLast(cmd);
        cmd.execute();

        return commands;
    }
}
