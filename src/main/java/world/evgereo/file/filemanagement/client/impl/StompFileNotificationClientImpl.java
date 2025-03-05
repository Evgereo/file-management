package world.evgereo.file.filemanagement.client.impl;

import world.evgereo.file.filemanagement.client.FileNotificationClient;
import world.evgereo.file.filemanagement.dto.FileNotificationMessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import static world.evgereo.file.filemanagement.constants.EndpointConstants.FILE_BROKER_ENDPOINT;

@Component
@RequiredArgsConstructor
public class StompFileNotificationClientImpl implements FileNotificationClient {
    private final SimpMessagingTemplate simpMessagingTemplate;

    @Override
    public void notify(FileNotificationMessageDto message) {
        simpMessagingTemplate.convertAndSend(FILE_BROKER_ENDPOINT, message);
    }
}
