package io.github.faizansaghir.designPatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private final String name;
    private int price;
    private int quantity;
    private final List<ProductObserver> priceObservers = new ArrayList<>();
    private final List<ProductObserver> quantityObservers = new ArrayList<>();

    public void attachForPrice(ProductObserver observer){
        priceObservers.add(observer);
    }
    public void detachFromPrice(ProductObserver observer){
        priceObservers.remove(observer);
    }
    public void attachForQuantity(ProductObserver observer){
        quantityObservers.add(observer);
    }
    public void detachFromQuantity(ProductObserver observer){
        quantityObservers.remove(observer);
    }
    public Product(String name) {
        this.name = name;
        price = 0;
        quantity = 0;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
        priceObservers.forEach(ob -> ob.update(this));
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        quantityObservers.forEach(ob -> ob.update(this));
    }

    public String getName() {
        return name;
    }
}
