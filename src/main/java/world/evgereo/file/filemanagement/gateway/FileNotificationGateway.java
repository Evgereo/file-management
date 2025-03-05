package world.evgereo.file.filemanagement.gateway;

import world.evgereo.file.filemanagement.model.FileInfo;

public interface FileNotificationGateway {

    void notify(FileInfo fileInfo, String message);

    void notify(String message);
}
