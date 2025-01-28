package io.github.faizansaghir.designPatterns.structural.composite.nonCommonFunctionalities;

public abstract class FileNonCommon {
    private String name;
    public FileNonCommon(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public abstract void ls();
    public abstract void addFile(FileNonCommon file);
    public abstract FileNonCommon[] getFiles();
    public abstract boolean removeFile(FileNonCommon file);
}
