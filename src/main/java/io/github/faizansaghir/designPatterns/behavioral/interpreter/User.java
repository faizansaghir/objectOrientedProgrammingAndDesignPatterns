package io.github.faizansaghir.designPatterns.behavioral.interpreter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class User {
    private final List<String> permissions;
    private final String username;

    public User(String username, String... permissions) {
        this.username = username;
        this.permissions = new ArrayList<>();
        Stream.of(permissions).forEach(e -> this.permissions.add(e.toLowerCase()));
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public String getUsername() {
        return username;
    }
}
