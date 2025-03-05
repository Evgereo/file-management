package world.evgereo.file.filemanagement.service;

public interface BucketStorageService {

    void create(String bucketName);

    void drop(String bucketName);
}
