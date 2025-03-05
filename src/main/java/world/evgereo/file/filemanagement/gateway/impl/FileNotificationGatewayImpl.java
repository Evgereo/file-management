package world.evgereo.file.filemanagement.gateway.impl;

import world.evgereo.file.filemanagement.client.FileNotificationClient;
import world.evgereo.file.filemanagement.dto.FileNotificationMessageDto;
import world.evgereo.file.filemanagement.gateway.FileNotificationGateway;
import world.evgereo.file.filemanagement.model.FileInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FileNotificationGatewayImpl implements FileNotificationGateway {
    private final FileNotificationClient fileNotificationClient;

    @Override
    public void notify(FileInfo fileInfo, String message) {
        fileNotificationClient.notify(FileNotificationMessageDto.builder()
                .fileName(fileInfo.getFileName())
                .bucketName(fileInfo.getBucketName())
                .size(fileInfo.getSize())
                .message(message)
                .build()
        );
    }

    @Override
    public void notify(String message) {
        fileNotificationClient.notify(FileNotificationMessageDto.builder()
                .message(message)
                .build()
        );
    }
}
