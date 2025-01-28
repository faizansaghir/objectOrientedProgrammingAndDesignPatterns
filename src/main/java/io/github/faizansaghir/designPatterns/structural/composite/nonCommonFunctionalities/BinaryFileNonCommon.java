package io.github.faizansaghir.designPatterns.structural.composite.nonCommonFunctionalities;

public class BinaryFileNonCommon extends FileNonCommon {
    private final long size;

    public BinaryFileNonCommon(String name, long size) {
        super(name);
        this.size = size;
    }

    @Override
    public void ls() {
        System.out.println(getName()+"\t"+size);
    }

    @Override
    public void addFile(FileNonCommon file) {
        throw new UnsupportedOperationException("Leaf node does not support add operation");
    }

    @Override
    public FileNonCommon[] getFiles() {
        throw new UnsupportedOperationException("Leaf node does not support get operation");
    }

    @Override
    public boolean removeFile(FileNonCommon file) {
        throw new UnsupportedOperationException("Leaf node does not support remove operation");
    }
}
