package io.github.faizansaghir.designPatterns.structural.composite.commonFunctionalities;

public class BinaryFileCommon extends FileCommon {
    private final long size;

    public BinaryFileCommon(String name, long size) {
        super(name);
        this.size = size;
    }

    @Override
    public void ls() {
        System.out.println(getName()+"\t"+size);
    }

}
