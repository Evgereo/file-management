package world.evgereo.file.filemanagement.service;

import org.springframework.data.domain.Page;
import world.evgereo.file.filemanagement.model.FileInfo;

public interface FileInfoService {

    Page<FileInfo> findAll(String bucketName, int pageNumber, int pageSize);

    FileInfo get(String bucketName, String fileName);

    FileInfo create(String bucketName, String fileName, long size);

    void delete(String bucketName, String fileName);
}
