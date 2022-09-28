package com.file.manager.operations.domain.directory;

import com.file.manager.operations.domain.FileDto;
import lombok.experimental.UtilityClass;

@UtilityClass
class DirectoryFinalizer {
    public void finalizeDir(Directory dir) {
        for (FileDto fileDto : dir.getFiles()) {
            //TODO: implement it
        }
    }
}
