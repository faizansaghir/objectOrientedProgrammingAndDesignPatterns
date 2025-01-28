package io.github.faizansaghir.designPatterns.structural.composite.commonFunctionalities;

import java.util.ArrayList;
import java.util.List;

public class DirectoryCommon extends FileCommon {
    private final List<FileCommon> children;

    public DirectoryCommon(String name) {
        super(name);
        children = new ArrayList<>();
    }

    @Override
    public void ls() {
        System.out.println(getName());
        children.forEach(FileCommon::ls);
    }

    public void addFile(FileCommon file) {
        children.add(file);
    }

    public FileCommon[] getFiles() {
        return children.toArray(new FileCommon[children.size()]);
    }

    public boolean removeFile(FileCommon file) {
        return children.remove(file);
    }


}
