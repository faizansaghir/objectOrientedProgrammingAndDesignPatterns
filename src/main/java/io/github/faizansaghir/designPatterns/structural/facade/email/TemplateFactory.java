package io.github.faizansaghir.designPatterns.structural.facade.email;

public class TemplateFactory {
    public static Template createTemplateFor(TemplateType templateType) {
        return new OrderEmailTemplate();
    }
}
