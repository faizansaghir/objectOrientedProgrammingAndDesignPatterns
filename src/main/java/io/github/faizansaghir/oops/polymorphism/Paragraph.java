package io.github.faizansaghir.oops.polymorphism;

public class Paragraph extends UIControl {
    public void displayText() {
        System.out.println("Text displayed");
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Paragraph");
    }
}
