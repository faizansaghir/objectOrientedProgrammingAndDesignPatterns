package io.github.faizansaghir.solid.singleResponsibility;

import com.google.gson.Gson;

public class UserJsonParser implements UserParser {


    @Override
    public User parseUserString(String userString) {
        Gson gson = new Gson();
        return gson.fromJson(userString, User.class);
    }
}
