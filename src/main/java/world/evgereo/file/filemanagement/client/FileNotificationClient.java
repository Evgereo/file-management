package world.evgereo.file.filemanagement.client;

import world.evgereo.file.filemanagement.dto.FileNotificationMessageDto;

public interface FileNotificationClient {

    void notify(FileNotificationMessageDto message);
}
