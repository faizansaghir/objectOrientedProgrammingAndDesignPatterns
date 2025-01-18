package io.github.faizansaghir.solid.singleResponsibility;

public class UserValidator {

    public boolean validateUser(User user){
        return isValid(user);
    }
    private boolean isValid(User user){
        return user.getName() != null && !user.getName().isEmpty();
    }
}
