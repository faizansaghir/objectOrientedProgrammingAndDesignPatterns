package io.github.faizansaghir.oops.polymorphism;

public abstract class UIControl {
    public void enable() {
        System.out.println("Enabled");
    }

    public abstract void draw();
}
