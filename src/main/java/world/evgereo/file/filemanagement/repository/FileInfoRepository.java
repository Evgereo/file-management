package world.evgereo.file.filemanagement.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import world.evgereo.file.filemanagement.model.FileInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.UUID;

public interface FileInfoRepository extends MongoRepository<FileInfo, UUID> {

    Page<FileInfo> findAllByBucketName(String bucketName, Pageable pageable);

    Optional<FileInfo> findByBucketNameAndFileName(String bucketName, String fileName);

    void deleteByBucketNameAndFileName(String bucketName, String fileName);
}
