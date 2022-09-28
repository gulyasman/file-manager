package com.file.manager.operations.domain.directory;

import com.file.manager.operations.domain.FileDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.nio.file.Path;
import java.util.List;

@Data
@NoArgsConstructor
public class Directory {
    private Path path;
    private List<Directory> directories;
    @ToString.Exclude
    private List<FileDto> files;

    Directory(Path path) {
        this.path = path;
    }

    public static Directory create(Path path) {
        return DirectoryReader.read(path);
    }
}
