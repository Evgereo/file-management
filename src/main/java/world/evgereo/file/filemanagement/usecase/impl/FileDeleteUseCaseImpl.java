package world.evgereo.file.filemanagement.usecase.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import world.evgereo.file.filemanagement.service.FileInfoService;
import world.evgereo.file.filemanagement.service.FileStorageService;
import world.evgereo.file.filemanagement.usecase.FileDeleteUseCase;

@Component
@RequiredArgsConstructor
public class FileDeleteUseCaseImpl implements FileDeleteUseCase {
    private final FileStorageService fileStorageService;
    private final FileInfoService fileInfoService;

    @Override
    @Transactional
    public void delete(String bucketName, String fileName) {
        fileInfoService.delete(bucketName, fileName);
        fileStorageService.delete(bucketName, fileName);
    }
}
