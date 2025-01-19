package io.github.faizansaghir.solid.interfaceSegregationPrinciple.common;

public class User extends Entity {

    private final String name;

    public User(Integer id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + super.getId() + "," +
                "name='" + name + '\'' +
                '}';
    }
}
