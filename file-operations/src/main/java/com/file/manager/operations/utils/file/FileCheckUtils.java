package com.file.manager.operations.utils.file;

import com.file.manager.operations.exception.NotDirectoryException;
import com.file.manager.operations.exception.NotExistsException;
import lombok.experimental.UtilityClass;

import java.nio.file.Files;
import java.nio.file.Path;

@UtilityClass
public class FileCheckUtils {
    public void checkDir(Path dir) {
        if (!isExist(dir)) {
            throw new NotExistsException("File not exists on given path: " + dir);
        }
        if (!isDir(dir)) {
            throw new NotDirectoryException("It is not a file on given path: " + dir);
        }
    }

    private boolean isExist(Path path) {
        return Files.exists(path);
    }

    private boolean isDir(Path path) {
        return Files.isDirectory(path);
    }
}
