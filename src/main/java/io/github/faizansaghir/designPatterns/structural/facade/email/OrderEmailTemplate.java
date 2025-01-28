package io.github.faizansaghir.designPatterns.structural.facade.email;

public class OrderEmailTemplate implements Template{
    @Override
    public String format(Object obj) {
        return "TEMPLATE";
    }
}
