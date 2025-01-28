package io.github.faizansaghir.designPatterns.structural.composite;

import io.github.faizansaghir.designPatterns.structural.composite.commonFunctionalities.BinaryFileCommon;
import io.github.faizansaghir.designPatterns.structural.composite.commonFunctionalities.DirectoryCommon;
import io.github.faizansaghir.designPatterns.structural.composite.commonFunctionalities.FileCommon;
import io.github.faizansaghir.designPatterns.structural.composite.nonCommonFunctionalities.BinaryFileNonCommon;
import io.github.faizansaghir.designPatterns.structural.composite.nonCommonFunctionalities.DirectoryNonCommon;
import io.github.faizansaghir.designPatterns.structural.composite.nonCommonFunctionalities.FileNonCommon;

public class CompositePatternMain {
    public static void main(String[] args) {
        FileNonCommon rootNonCommon = createTreeOne();
        rootNonCommon.ls();
        System.out.println("===================================");
        FileCommon rootCommon = createTreeTwo();
        rootCommon.ls();
    }
    private static FileNonCommon createTreeOne() {
        FileNonCommon file1 = new BinaryFileNonCommon("File1", 1000);
        FileNonCommon dir1 = new DirectoryNonCommon("dir1");
        dir1.addFile(file1);
        FileNonCommon file2 = new BinaryFileNonCommon("File2", 2000);
        FileNonCommon file3 = new BinaryFileNonCommon("File3", 150);
        FileNonCommon dir2 = new DirectoryNonCommon("dir2");
        dir2.addFile(file2);
        dir2.addFile(file3);
        dir2.addFile(dir1);
        return dir2;
    }
    private static FileCommon createTreeTwo() {
        FileCommon file1 = new BinaryFileCommon("File1", 1000);
        DirectoryCommon dir1 = new DirectoryCommon("dir1");
        dir1.addFile(file1);
        FileCommon file2 = new BinaryFileCommon("File2", 2000);
        FileCommon file3 = new BinaryFileCommon("File3", 150);
        DirectoryCommon dir2 = new DirectoryCommon("dir2");
        dir2.addFile(file2);
        dir2.addFile(file3);
        dir2.addFile(dir1);
        return dir2;
    }
}
