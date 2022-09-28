package com.file.manager.operations.domain;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.InputStream;
import java.nio.file.Path;

@ToString
@EqualsAndHashCode
public class FileDto {
    private final Path originalFilePath;
    private Path newFilePath;
    private InputStream content;

    public FileDto(Path originalFilePath, InputStream content) {
        this.originalFilePath = originalFilePath;
        this.content = content;
    }

    public Path getOriginalFilePath() {
        return originalFilePath;
    }

    public Path getNewFilePath() {
        return newFilePath;
    }

    public void setNewFilePath(Path newFilePath) {
        this.newFilePath = newFilePath;
    }

    public InputStream getContent() {
        return content;
    }

    public void setContent(InputStream newContent) {
        this.content = newContent;
    }
}
