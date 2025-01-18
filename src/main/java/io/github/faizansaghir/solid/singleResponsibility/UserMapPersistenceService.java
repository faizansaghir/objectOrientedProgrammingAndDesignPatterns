package io.github.faizansaghir.solid.singleResponsibility;

import java.util.HashMap;
import java.util.Map;

public class UserMapPersistenceService implements UserPersistenceService{

    Map<Integer, User> userMap;

    public UserMapPersistenceService() {
        this.userMap = new HashMap<>();
    }

    @Override
    public void persistUser(User user) {
        synchronized (this) {
            userMap.put(user.getId(), user);
        }
    }
}
