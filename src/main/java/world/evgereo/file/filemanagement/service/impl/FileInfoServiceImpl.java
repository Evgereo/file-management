package world.evgereo.file.filemanagement.service.impl;

import static world.evgereo.file.filemanagement.constants.ErrorCodeConstants.FILE_INFO_ALREADY_EXISTS_ERROR;
import static world.evgereo.file.filemanagement.constants.ErrorCodeConstants.FILE_INFO_NOT_FOUND_ERROR;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import world.evgereo.file.filemanagement.exception.BusinessException;
import world.evgereo.file.filemanagement.model.FileInfo;
import world.evgereo.file.filemanagement.repository.FileInfoRepository;
import world.evgereo.file.filemanagement.service.FileInfoService;
import world.evgereo.file.filemanagement.utils.FileUtils;

@Service
@RequiredArgsConstructor
public class FileInfoServiceImpl implements FileInfoService {
    private final FileInfoRepository fileInfoRepository;

    @Override
    public Page<FileInfo> findAll(String bucketName, int pageNumber, int pageSize) {
        var pageRequest = PageRequest.of(pageNumber, pageSize);
        return fileInfoRepository.findAllByBucketName(bucketName, pageRequest);
    }

    @Override
    public FileInfo get(String bucketName, String fileName) {
        return fileInfoRepository.findByBucketNameAndFileName(bucketName, fileName)
                .orElseThrow(() -> new BusinessException(FILE_INFO_NOT_FOUND_ERROR, "Failed find file by bucket and file name"));
    }

    @Override
    public FileInfo create(String bucketName, String fileName, long size) {
        fileInfoRepository.findByBucketNameAndFileName(bucketName, fileName)
                .ifPresent(fileInfo -> {
                    var message = "File with with id: %s already exists in bucket: %s"
                            .formatted(fileInfo.getId(), fileInfo.getFileName());
                    throw new BusinessException(FILE_INFO_ALREADY_EXISTS_ERROR, message);
                });
        return fileInfoRepository.insert(FileUtils.build(bucketName, fileName, size));
    }

    @Override
    public void delete(String bucketName, String fileName) {
        fileInfoRepository.deleteByBucketNameAndFileName(bucketName, fileName);
    }
}
