package world.evgereo.file.filemanagement.usecase.impl;

import static world.evgereo.file.filemanagement.constants.MessageConstants.FAILED_NOTIFICATION;
import static world.evgereo.file.filemanagement.constants.MessageConstants.SUCCESSFUL_NOTIFICATION;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import world.evgereo.file.filemanagement.gateway.FileNotificationGateway;
import world.evgereo.file.filemanagement.service.FileInfoService;
import world.evgereo.file.filemanagement.service.FileStorageService;
import world.evgereo.file.filemanagement.usecase.FileUploadUseCase;

@Component
@RequiredArgsConstructor
public class FileUploadUseCaseImpl implements FileUploadUseCase {
    private final FileNotificationGateway fileNotificationGateway;
    private final FileStorageService fileStorageService;
    private final FileInfoService fileInfoService;

    @Async
    @Override
    @Transactional
    public void upload(String bucketName, MultipartFile file) {
        var fileName = file.getOriginalFilename();
        var fileInfo = fileInfoService.create(bucketName, fileName, file.getSize());
        try {
            fileStorageService.put(bucketName, file);
            fileNotificationGateway.notify(fileInfo, SUCCESSFUL_NOTIFICATION.formatted(fileName));
        } catch (Exception ex) {
            fileNotificationGateway.notify(FAILED_NOTIFICATION.formatted(fileName));
        }
    }
}
