package io.github.faizansaghir.solid.dependencyInversionPrinciple;


import io.github.faizansaghir.solid.dependencyInversionPrinciple.good.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class DependencyInversionPrincipleGoodMain {
    public static void main(String[] args) throws IOException {
        Formatter formatter = new JsonFormatter();
        Writer writer = new PrintWriter(new FileWriter("log.txt", true));
        Logger loggerFile = new Logger(formatter, writer);
        loggerFile.log("Started File");
        loggerFile.log("Ended File");

        Logger loggerConsole = new Logger(formatter, System.console().writer());
        loggerConsole.log("Started Console");
        loggerConsole.log("Ended Console");
    }
}
