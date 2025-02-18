package io.github.faizansaghir.designPatterns.observer;

public class PriceObserver implements ProductObserver{

    @Override
    public void update(Product product) {
        System.out.println("Price of "+product.getName()+" is updated to "+product.getPrice());
    }
}
