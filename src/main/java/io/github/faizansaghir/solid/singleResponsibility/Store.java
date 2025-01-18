package io.github.faizansaghir.solid.singleResponsibility;

import java.util.HashMap;
import java.util.Map;

public class Store {
    Map<Integer, User> userMap;
    int id;

    public Store(){
        userMap = new HashMap<>();
        id=0;
    }

    public void store(User user){
        synchronized (this) {
            user.setId(id++);
            userMap.put(user.getId(), user);
        }
    }
}
