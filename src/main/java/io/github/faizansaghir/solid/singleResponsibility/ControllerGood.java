package io.github.faizansaghir.solid.singleResponsibility;

import com.google.gson.Gson;

public class ControllerGood {

    private final UserParser userParser;
    private final UserPersistenceService userPersistenceService;
    private final UserValidator userValidator;

    public ControllerGood() {
        this.userParser = new UserJsonParser();
        this.userPersistenceService = new UserMapPersistenceService();
        this.userValidator = new UserValidator();
    }

    public String createUser(String userString){
        User user = userParser.parseUserString(userString);

        boolean isValid = userValidator.validateUser(user);

        if(!isValid) {
            return "ERROR";
        }

        userPersistenceService.persistUser(user);

        return "SUCCESS";
    }
}
