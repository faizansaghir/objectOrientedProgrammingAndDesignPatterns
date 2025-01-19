package io.github.faizansaghir.solid.dependencyInversionPrinciple.good;

import io.github.faizansaghir.solid.dependencyInversionPrinciple.Formatter;
import io.github.faizansaghir.solid.dependencyInversionPrinciple.JsonFormatter;
import io.github.faizansaghir.solid.dependencyInversionPrinciple.Message;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class Logger {
    Formatter formatter;
    Writer writer;
    public Logger(Formatter formatter, Writer writer) {
        this.formatter = formatter;
        this.writer = writer;
    }
    public void log(String messageString) {
        Message message = new Message(messageString);

        String logString = formatter.format(message);
        try {
            writer.write(logString);
            writer.write("\n");
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
