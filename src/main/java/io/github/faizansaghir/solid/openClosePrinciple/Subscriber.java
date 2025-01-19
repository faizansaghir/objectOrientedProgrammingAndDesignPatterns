package io.github.faizansaghir.solid.openClosePrinciple;

public abstract class Subscriber {
    private final Long id;
    private String name;

    public Subscriber(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public abstract Float calculateBill();
}
