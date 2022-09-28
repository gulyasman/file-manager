package com.file.manager.operations.utils.file;

import lombok.experimental.UtilityClass;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@UtilityClass
public class FileReadUtils {
    public List<Path> readFiles(Path dir) {
        FileCheckUtils.checkDir(dir);
        return readChildFiles(dir);
    }

    private List<Path> readChildFiles(Path path) {
        List<Path> paths = new ArrayList<>();
        for(File file: Objects.requireNonNull(path.toFile().listFiles())) {
            if(file.isDirectory()) {
                paths.addAll(readChildFiles(file.toPath()));
            } else {
                paths.add(file.toPath());
            }
        }
        return paths;
    }
}
