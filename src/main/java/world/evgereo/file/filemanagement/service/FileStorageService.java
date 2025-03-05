package world.evgereo.file.filemanagement.service;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

public interface FileStorageService {

    StreamingResponseBody get(String bucketName, String fileName);

    void put(String bucketName, MultipartFile file);

    void delete(String bucketName, String fileName);
}
