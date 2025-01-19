package io.github.faizansaghir.solid.dependencyInversionPrinciple;

import io.github.faizansaghir.solid.dependencyInversionPrinciple.bad.Logger;

public class DependencyInversionPrincipleBadMain {
    public static void main(String[] args) {
        Logger logger = new Logger();
        logger.log("Started");
        logger.log("Ended");
    }
}
