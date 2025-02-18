package io.github.faizansaghir.designPatterns.observer;

public class QuantityObserver implements ProductObserver{
    @Override
    public void update(Product product) {
        System.out.println("Quantity of "+product.getName()+" is updated to "+product.getQuantity());
    }
}
