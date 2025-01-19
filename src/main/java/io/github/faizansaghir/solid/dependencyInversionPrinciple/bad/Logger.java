package io.github.faizansaghir.solid.dependencyInversionPrinciple.bad;

import io.github.faizansaghir.solid.dependencyInversionPrinciple.JsonFormatter;
import io.github.faizansaghir.solid.dependencyInversionPrinciple.Message;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
    public void log(String messageString) {
        Message message = new Message(messageString);

        JsonFormatter formatter = new JsonFormatter();

        String logString = formatter.format(message);

        try (PrintWriter writer = new PrintWriter(new FileWriter("log.txt", true))){
            writer.println(logString);
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
