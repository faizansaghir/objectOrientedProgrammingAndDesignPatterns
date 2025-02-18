package io.github.faizansaghir.designPatterns.observer;

public class ObserverPatternMain {
    public static void main(String[] args) {
        Product p1 = new Product("Soap");
        Product p2 = new Product("Shampoo");
        System.out.println("-----------------------------------");
        p1.setPrice(1);
        p2.setPrice(10);
        p1.setQuantity(5);
        p2.setQuantity(3);

        PriceObserver priceObserver = new PriceObserver();
        p1.attachForPrice(priceObserver);
        p2.attachForPrice(priceObserver);
        System.out.println("-----------------------------------");
        p1.setPrice(2);
        p2.setQuantity(5);

        QuantityObserver quantityObserver = new QuantityObserver();
        p1.attachForQuantity(quantityObserver);
        p2.attachForQuantity(quantityObserver);
        System.out.println("-----------------------------------");
        p1.setPrice(3);
        p2.setPrice(25);
        p2.setQuantity(10);

        p1.detachFromPrice(priceObserver);
        p2.detachFromQuantity(quantityObserver);
        System.out.println("-----------------------------------");
        p1.setPrice(1);
        p2.setPrice(10);
        p1.setQuantity(5);
        p2.setQuantity(3);

        p1.detachFromQuantity(quantityObserver);
        p2.detachFromPrice(priceObserver);
        System.out.println("-----------------------------------");
        p1.setPrice(10);
        p2.setPrice(100);
        p1.setQuantity(50);
        p2.setQuantity(30);
    }
}
