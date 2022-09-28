package com.file.manager.operations.utils.file;

import com.file.manager.operations.TestUtils;
import com.file.manager.operations.exception.NotDirectoryException;
import com.file.manager.operations.exception.NotExistsException;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FileCheckUtilsTest {
    private static final Path FOLDER_PATH = Path.of("folder");
    private static final Path FILE_PATH = Path.of("file");
    private static Path contentDir;

    @BeforeAll
    static void beforeAll() {
        contentDir = TestUtils.prepareTestContent(List.of(FOLDER_PATH), FILE_PATH);
    }

    @Test
    void checkDirShouldThrowNotExistsExceptionWhenFileNotExists() {
        // GIVEN
        Path notExistingFile = Path.of("NOT_EXIST.txt");

        // WHEN
        System.out.println(contentDir);

        // THEN
        assertThatThrownBy(() -> FileCheckUtils.checkDir(notExistingFile)).isInstanceOf(NotExistsException.class);
    }

    @Test
    void checkDirShouldThrowNotDirectoryExceptionWhenInputIsFile() {
        // GIVEN
        Path file = contentDir.resolve(FILE_PATH);

        // WHEN

        // THEN
        assertThatThrownBy(() -> FileCheckUtils.checkDir(file)).isInstanceOf(NotDirectoryException.class);
    }

    @Test
    void checkDirShouldNotThrowExceptionWhenInputIsFolder() {
        // GIVEN
        Path folder = contentDir.resolve(FOLDER_PATH);

        // WHEN

        // THEN
        FileCheckUtils.checkDir(folder);
    }

    @AfterAll
    static void afterAll() {
        FileUtils.deleteQuietly(contentDir.toFile());
    }
}