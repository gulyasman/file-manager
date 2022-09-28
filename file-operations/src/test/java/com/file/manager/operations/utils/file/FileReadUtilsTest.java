package com.file.manager.operations.utils.file;

import com.file.manager.operations.TestUtils;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FileReadUtilsTest {
    private static final Path FILE_ONE = Path.of("file1");
    private static final Path FOLDER_ONE = Path.of("folder1");
    private static final Path FILE_TWO = FOLDER_ONE.resolve(Path.of("file2"));
    private static final Path FOLDER_TWO = FOLDER_ONE.resolve(Path.of("folder2"));
    private static final Path FILE_THREE = FOLDER_TWO.resolve(Path.of("file3"));
    private static Path contentDir;

    @BeforeAll
    static void beforeAll() {
        contentDir = TestUtils.prepareTestContent(
                List.of(
                    FOLDER_ONE, FOLDER_TWO
                ),
                FILE_ONE, FILE_TWO, FILE_THREE
        );
    }

    @Test
    void readFilesShouldReturnThePathOfFiles() {
        // GIVEN
        int expectedNumberOfFiles = 3;
        Path fileOne = contentDir.resolve(FILE_ONE);
        Path fileTwo = contentDir.resolve(FILE_TWO);
        Path fileThree = contentDir.resolve(FILE_THREE);

        // WHEN
        List<Path> actual = FileReadUtils.readFiles(contentDir);

        // THEN
        assertThat(actual).hasSize(expectedNumberOfFiles).containsExactlyInAnyOrder(fileOne, fileTwo, fileThree);
    }

    @AfterAll
    static void afterAll() {
        FileUtils.deleteQuietly(contentDir.toFile());
    }
}