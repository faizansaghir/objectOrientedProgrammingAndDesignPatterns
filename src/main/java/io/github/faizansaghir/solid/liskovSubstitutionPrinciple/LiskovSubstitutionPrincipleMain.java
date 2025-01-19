package io.github.faizansaghir.solid.liskovSubstitutionPrinciple;

public class LiskovSubstitutionPrincipleMain {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.setHeight(10);
        rectangle.setWidth(20);
        System.out.printf("Width of rectangle: %d\n", rectangle.getWidth());
        System.out.printf("Height of rectangle: %d\n", rectangle.getHeight());
        System.out.printf("Area of rectangle: %d\n", rectangle.getArea());

        Rectangle square = new Square();
        square.setHeight(10);
        square.setWidth(20);
        System.out.printf("Width of square: %d\n", square.getWidth());
        System.out.printf("Height of square: %d\n", square.getHeight());
        System.out.printf("Area of square: %d\n", square.getArea());
    }
}
