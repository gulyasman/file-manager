package com.file.manager.operations.domain.directory;

import com.file.manager.operations.domain.FileDto;
import com.file.manager.operations.exception.FileOperationsException;
import com.file.manager.operations.utils.file.FileCheckUtils;
import lombok.experimental.UtilityClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@UtilityClass
class DirectoryReader {
    public Directory read(Path path) {
        FileCheckUtils.checkDir(path);
        return readDirectory(path);
    }

    private Directory readDirectory(Path path) {
        Directory directory = new Directory(path);
        List<FileDto> files = new ArrayList<>();
        List<Directory> directories = new ArrayList<>();
        for (File file : path.toFile().listFiles()) {
            if (file.isDirectory()) {
                directories.add(readDirectory(file.toPath()));
            } else {
                handleFile(files, file);
            }
        }
        directory.setFiles(files);
        directory.setDirectories(directories);
        return directory;
    }

    private void handleFile(List<FileDto> files, File file) {
        try (InputStream inputStream = new FileInputStream(file)) {
            files.add(new FileDto(file.toPath(), inputStream));
        } catch (IOException e) {
            throw new FileOperationsException("Error while read file: " + file);
        }
    }
}
