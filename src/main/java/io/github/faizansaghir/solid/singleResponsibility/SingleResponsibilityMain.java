package io.github.faizansaghir.solid.singleResponsibility;

public class SingleResponsibilityMain {
    public static void main(String[] args) {
        String validJson = "{\"name\":\"Faizan\"}";
        String invalidJson = "{\"name\":\"\"}";

        ControllerBad controllerBad = new ControllerBad();

        String responseValid = controllerBad.createUser(validJson);
        String responseInvalid = controllerBad.createUser(invalidJson);
        System.out.println(responseValid);
        System.out.println(responseInvalid);

        ControllerGood controllerGood = new ControllerGood();

        responseValid = controllerGood.createUser(validJson);
        responseInvalid = controllerGood.createUser(invalidJson);
        System.out.println(responseValid);
        System.out.println(responseInvalid);
    }
}
