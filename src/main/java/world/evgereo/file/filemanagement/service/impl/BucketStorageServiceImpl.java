package world.evgereo.file.filemanagement.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import world.evgereo.file.filemanagement.service.BucketStorageService;
import world.evgereo.file.filemanagement.utils.MinioRequestUtils;
import world.evgereo.spring.minio.service.MinioService;

@Service
@RequiredArgsConstructor
public class BucketStorageServiceImpl implements BucketStorageService {
    private final MinioService minioService;

    @Override
    public void create(String bucketName) {
        minioService.makeBucket(MinioRequestUtils.buildCreateBucketRequest(bucketName));
    }

    @Override
    public void drop(String bucketName) {
        minioService.removeBucket(MinioRequestUtils.buildDropBucketRequest(bucketName));
    }
}
