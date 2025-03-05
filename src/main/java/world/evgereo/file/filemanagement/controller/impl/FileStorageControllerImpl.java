package world.evgereo.file.filemanagement.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;
import world.evgereo.file.filemanagement.controller.FileStorageController;
import world.evgereo.file.filemanagement.service.FileStorageService;
import world.evgereo.file.filemanagement.usecase.FileDeleteUseCase;
import world.evgereo.file.filemanagement.usecase.FileUploadUseCase;

@RestController
@RequiredArgsConstructor
public class FileStorageControllerImpl implements FileStorageController {
    private final FileUploadUseCase fileUploadUseCase;
    private final FileDeleteUseCase fileDeleteUseCase;
    private final FileStorageService service;

    @Override
    public StreamingResponseBody download(String bucketName, String fileName) {
        return service.get(bucketName, fileName);
    }

    @Override
    public void upload(String bucketName, MultipartFile file) {
        fileUploadUseCase.upload(bucketName, file);
    }

    @Override
    public void delete(String bucketName, String fileName) {
        fileDeleteUseCase.delete(bucketName, fileName);
    }
}
