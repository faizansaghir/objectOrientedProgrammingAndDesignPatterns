package io.github.faizansaghir.solid.interfaceSegregationPrinciple.good;

import io.github.faizansaghir.solid.interfaceSegregationPrinciple.common.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserPersistenceService implements EntityPersistenceService<User> {
    Map<Integer, User> userMap;
    public UserPersistenceService() {
        userMap = new HashMap<>();
    }

    @Override
    public void save(User entity) {
        synchronized (this) {
            userMap.put(entity.getId(), entity);
        }
    }

    @Override
    public User getById(Integer id) {
        return userMap.getOrDefault(id, null);
    }

    public List<User> getByName(String name) {
        List<User> users = new ArrayList<>();
        for(User user: userMap.values()) {
            if(user.getName().equals(name))
                users.add(user);
        }
        return users;
    }
}
