package io.github.faizansaghir.solid.interfaceSegregationPrinciple.common;

public class Entity {
    private final Integer id;

    public Entity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
