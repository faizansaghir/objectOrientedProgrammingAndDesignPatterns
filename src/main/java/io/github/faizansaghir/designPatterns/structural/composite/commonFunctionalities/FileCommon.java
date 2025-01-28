package io.github.faizansaghir.designPatterns.structural.composite.commonFunctionalities;

public abstract class FileCommon {
    private String name;
    public FileCommon(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public abstract void ls();
}
