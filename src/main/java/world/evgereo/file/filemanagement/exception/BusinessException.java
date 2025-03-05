package world.evgereo.file.filemanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BusinessException extends AbstractFileManagementException {
    public BusinessException(String code, String message) {
        super(code, message);
    }
}
