package world.evgereo.file.filemanagement.utils;

import java.util.UUID;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import world.evgereo.file.filemanagement.model.FileInfo;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FileUtils {

    public static FileInfo build(String bucketName, String fileName, long size) {
        return FileInfo.builder()
                .id(UUID.randomUUID())
                .bucketName(bucketName)
                .fileName(fileName)
                .size(size)
                .build();
    }
}
