package world.evgereo.file.filemanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class SystemException extends AbstractFileManagementException {
    public SystemException(String code, String message) {
        super(code, message);
    }
}
