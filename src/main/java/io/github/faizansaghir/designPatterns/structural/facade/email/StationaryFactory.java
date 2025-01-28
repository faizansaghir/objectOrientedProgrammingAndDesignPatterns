package io.github.faizansaghir.designPatterns.structural.facade.email;

public class StationaryFactory {
    public static Stationary createStationary(){
        return new HalloweenStationary();
    }
}
