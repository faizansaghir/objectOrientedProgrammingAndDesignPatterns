package io.github.faizansaghir.designPatterns.structural.composite.nonCommonFunctionalities;

import java.util.ArrayList;
import java.util.List;

public class DirectoryNonCommon extends FileNonCommon {
    private final List<FileNonCommon> children;

    public DirectoryNonCommon(String name) {
        super(name);
        children = new ArrayList<>();
    }

    @Override
    public void ls() {
        System.out.println(getName());
        children.forEach(FileNonCommon::ls);
    }

    @Override
    public void addFile(FileNonCommon file) {
        children.add(file);
    }

    @Override
    public FileNonCommon[] getFiles() {
        return children.toArray(new FileNonCommon[children.size()]);
    }

    @Override
    public boolean removeFile(FileNonCommon file) {
        return children.remove(file);
    }


}
