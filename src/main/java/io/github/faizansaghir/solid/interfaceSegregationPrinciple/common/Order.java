package io.github.faizansaghir.solid.interfaceSegregationPrinciple.common;

import io.github.faizansaghir.solid.interfaceSegregationPrinciple.common.Entity;

public class Order extends Entity {
    private final Integer value;

    public Order(Integer id, Integer value) {
        super(id);
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + super.getId() + "," +
                "value=" + value +
                '}';
    }
}
