package io.github.faizansaghir.designPatterns.mediator;

public class Slider extends javafx.scene.control.Slider implements UIControl {
    private final UIMediator mediator;
    private boolean mediatedUpdate;
    public Slider(UIMediator mediator){
        this.mediator = mediator;
        this.setMin(0);
        this.setMax(50);
        setBlockIncrement(5);
        this.mediator.register(this);

        this.valueProperty().addListener((v, o, n) -> {
            if(!mediatedUpdate)
                this.mediator.valueChanged(this);
        });
    }

    @Override
    public void controlChanged(UIControl control) {
        this.mediatedUpdate = true;
        this.setValue(Double.parseDouble(control.getControlValue()));
        this.mediatedUpdate = false;
    }

    @Override
    public String getControlValue() {
        return String.valueOf(getValue());
    }

    @Override
    public String getControlName() {
        return "Slider";
    }
}
