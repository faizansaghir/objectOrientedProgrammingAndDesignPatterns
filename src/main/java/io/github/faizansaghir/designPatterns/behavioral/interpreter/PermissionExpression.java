package io.github.faizansaghir.designPatterns.behavioral.interpreter;

public interface PermissionExpression {
    boolean interpret(User user);
}
