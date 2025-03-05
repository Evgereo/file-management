package world.evgereo.file.filemanagement.usecase.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import world.evgereo.file.filemanagement.service.BucketInfoService;
import world.evgereo.file.filemanagement.service.BucketStorageService;
import world.evgereo.file.filemanagement.usecase.BucketDropUseCase;

@Component
@RequiredArgsConstructor
public class BucketDropUseCaseImpl implements BucketDropUseCase {
    private final BucketInfoService bucketInfoService;
    private final BucketStorageService bucketStorageService;

    @Override
    public void drop(String bucketName) {
        bucketStorageService.drop(bucketName);
        bucketInfoService.delete(bucketName);
    }
}
