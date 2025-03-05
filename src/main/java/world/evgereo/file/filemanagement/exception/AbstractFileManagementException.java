package world.evgereo.file.filemanagement.exception;

import lombok.Getter;

@Getter
public abstract class AbstractFileManagementException extends RuntimeException {
    private final String code;

    public AbstractFileManagementException(String code, String message) {
        super(message);
        this.code = code;
    }
}
