package io.github.faizansaghir.solid.singleResponsibility;

import com.google.gson.Gson;

public class ControllerBad {
    private final Store store = new Store();

    public String createUser(String userJson) {
        Gson gson = new Gson();
        User user = gson.fromJson(userJson, User.class);

        if(!isValid(user)) {
            return "ERROR";
        }

        store.store(user);

        return "SUCCESS";
    }

    private boolean isValid(User user){
        return user.getName() != null && !user.getName().isEmpty();
    }
}
