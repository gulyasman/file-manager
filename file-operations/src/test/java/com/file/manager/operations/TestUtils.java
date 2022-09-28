package com.file.manager.operations;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@UtilityClass
public class TestUtils {
    private static final String TEMP_PREFIX = "content-dir";

    @SneakyThrows
    public Path prepareTestContent(List<Path> folders, Path... files) {
        Path contentDir = Files.createTempDirectory(TEMP_PREFIX);
        for(Path path: folders) {
            Files.createDirectories(contentDir.resolve(path));
        }
        for(Path path: files) {
            Files.createFile(contentDir.resolve(path));
        }
        return contentDir;
    }
}
