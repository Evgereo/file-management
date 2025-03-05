package world.evgereo.file.filemanagement.service;

import world.evgereo.file.filemanagement.model.BucketInfo;

public interface BucketInfoService {

    BucketInfo get(String bucketName);

    BucketInfo create(BucketInfo bucketInfo);

    void delete(String bucketName);
}
