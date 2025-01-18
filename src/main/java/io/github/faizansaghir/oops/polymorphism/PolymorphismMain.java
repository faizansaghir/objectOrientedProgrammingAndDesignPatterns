package io.github.faizansaghir.oops.polymorphism;

public class PolymorphismMain {
    public static void main(String[] args) {
        TextBox textBox = new TextBox();
        Paragraph paragraph = new Paragraph();
        drawUIControl(textBox);
        drawUIControl(paragraph);
    }
    public static void drawUIControl(UIControl uiControl){
        uiControl.draw();
    }
}
