package world.evgereo.file.filemanagement.usecase.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import world.evgereo.file.filemanagement.model.BucketInfo;
import world.evgereo.file.filemanagement.service.BucketInfoService;
import world.evgereo.file.filemanagement.service.BucketStorageService;
import world.evgereo.file.filemanagement.usecase.BucketCreateUseCase;

@Component
@RequiredArgsConstructor
public class BucketCreateUseCaseImpl implements BucketCreateUseCase {
    private final BucketStorageService bucketStorageService;
    private final BucketInfoService bucketInfoService;

    @Override
    @Transactional
    public BucketInfo create(BucketInfo bucketInfo) {
        var createdBucketInfo = bucketInfoService.create(bucketInfo);
        bucketStorageService.create(bucketInfo.getName());
        return createdBucketInfo;
    }
}
