package io.github.faizansaghir.designPatterns.memento;

import java.util.Arrays;
import java.util.LinkedList;

public class Workflow {
    private LinkedList<String> steps;
    private final String name;

    public Workflow(String name) {
        this.name = name;
        this.steps = new LinkedList<>();
    }

    public Workflow(String name, String... steps) {
        this.steps = new LinkedList<>();
        if(steps!=null && steps.length>0){
            this.steps.addAll(Arrays.asList(steps));
        }
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Workflow [name=");
        builder.append(name).append("]\nBEGIN -> ");
        for(String step:steps){
            builder.append(step).append(" -> ");
        }
        builder.append("END");
        return builder.toString();
    }

    public void addStep(String step) {
        steps.add(step);
    }

    public void removeStep(String step) {
        steps.remove(step);
    }

    public String[] getSteps() {
        return steps.toArray(new String[0]);
    }

    public String getName() {
        return name;
    }
}
