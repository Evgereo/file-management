package world.evgereo.file.filemanagement.repository;

import world.evgereo.file.filemanagement.model.BucketInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BucketInfoRepository extends MongoRepository<BucketInfo, String> {

    Optional<BucketInfo> findByName(String name);

    void deleteByName(String name);
}
