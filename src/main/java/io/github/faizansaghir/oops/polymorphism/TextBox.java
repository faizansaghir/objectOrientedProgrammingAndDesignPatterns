package io.github.faizansaghir.oops.polymorphism;

public class TextBox extends UIControl {
    public void acceptInput() {
        System.out.println("Accepting input");
    }

    @Override
    public void draw() {
        System.out.println("Drawing a TextBox");
    }
}
