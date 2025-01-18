package io.github.faizansaghir.inheritance;

public class InheritanceMain {
    public static void main(String[] args) {
        TextBox textBox = new TextBox();
        textBox.enable();
        textBox.acceptInput();
        Paragraph paragraph = new Paragraph();
        paragraph.enable();
        paragraph.displayText();
    }
}
