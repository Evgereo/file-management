package world.evgereo.file.filemanagement.usecase;

import world.evgereo.file.filemanagement.model.BucketInfo;

public interface BucketCreateUseCase {

    BucketInfo create(BucketInfo bucketInfo);
}
