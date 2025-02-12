package io.github.faizansaghir.designPatterns.mediator;

public interface UIControl {
    void controlChanged(UIControl control);
    String getControlValue();
    String getControlName();
}
