package io.github.faizansaghir.designPatterns.mediator;

public class Label extends javafx.scene.control.Label implements UIControl {
    public Label(UIMediator mediator){
        mediator.register(this);
    }

    @Override
    public void controlChanged(UIControl control) {
        setText(control.getControlValue());
    }

    @Override
    public String getControlValue() {
        return getText();
    }

    @Override
    public String getControlName() {
        return "Label";
    }
}
