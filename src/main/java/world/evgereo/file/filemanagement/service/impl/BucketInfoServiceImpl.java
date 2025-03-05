package world.evgereo.file.filemanagement.service.impl;

import static world.evgereo.file.filemanagement.constants.ErrorCodeConstants.BUCKET_INFO_NOT_FOUND_ERROR;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import world.evgereo.file.filemanagement.exception.BusinessException;
import world.evgereo.file.filemanagement.model.BucketInfo;
import world.evgereo.file.filemanagement.repository.BucketInfoRepository;
import world.evgereo.file.filemanagement.service.BucketInfoService;

@Service
@RequiredArgsConstructor
public class BucketInfoServiceImpl implements BucketInfoService {
    private final BucketInfoRepository bucketInfoRepository;

    @Override
    public BucketInfo get(String bucketName) {
        return bucketInfoRepository.findByName(bucketName)
                .orElseThrow(() ->
                        new BusinessException(BUCKET_INFO_NOT_FOUND_ERROR, "Failed to find bucket by name: " + bucketName)
                );
    }

    @Override
    public BucketInfo create(BucketInfo bucketInfo) {
        return bucketInfoRepository.save(bucketInfo);
    }

    @Override
    public void delete(String bucketName) {
        bucketInfoRepository.deleteByName(bucketName);
    }
}
