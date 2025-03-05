package world.evgereo.file.filemanagement.exception;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import world.evgereo.file.filemanagement.dto.ErrorDto;
import world.evgereo.file.filemanagement.helper.ErrorHelper;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {
    private final ErrorHelper errorHelper;

    @ExceptionHandler(BusinessException.class)
    public ErrorDto handleBusinessException(BusinessException ex) {
        log.info("Business error occurs: " + ex.getMessage());
        return errorHelper.buildErrorDto(ex);
    }

    @ExceptionHandler(SystemException.class)
    public ErrorDto handleSystemException(SystemException ex) {
        log.warn("System error occurs: " + ex.getMessage());
        return errorHelper.buildErrorDto(ex);
    }
}
