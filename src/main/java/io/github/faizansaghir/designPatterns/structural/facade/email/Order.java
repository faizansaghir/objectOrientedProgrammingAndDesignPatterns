package io.github.faizansaghir.designPatterns.structural.facade.email;

public class Order {
    private final String id;
    private final double value;
    public Order(String orderId, double value) {
        this.id = orderId;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public double getValue() {
        return value;
    }
}
