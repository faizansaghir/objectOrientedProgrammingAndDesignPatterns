package io.github.faizansaghir.solid.dependencyInversionPrinciple;

import com.google.gson.Gson;

public class JsonFormatter implements Formatter{
    @Override
    public String format(Message message) {
        Gson gson = new Gson();
        return gson.toJson(message, Message.class);
    }
}
