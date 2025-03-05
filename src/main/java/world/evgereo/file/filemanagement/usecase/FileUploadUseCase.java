package world.evgereo.file.filemanagement.usecase;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadUseCase {

    void upload(String bucketName, MultipartFile file);
}
