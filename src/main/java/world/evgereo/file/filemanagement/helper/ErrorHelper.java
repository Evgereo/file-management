package world.evgereo.file.filemanagement.helper;

import java.time.Clock;
import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;
import world.evgereo.file.filemanagement.dto.ErrorDto;
import world.evgereo.file.filemanagement.exception.AbstractFileManagementException;
import world.evgereo.file.filemanagement.utils.HttpStatusExtractorUtils;

@Component
@RequiredArgsConstructor
public class ErrorHelper {
    private final MessageSourceAccessor messageSourceAccessor;
    private final Clock clock;

    public ErrorDto buildErrorDto(AbstractFileManagementException ex) {
        return ErrorDto.builder()
                .id(UUID.randomUUID()) //TODO: add ThreadLocalStorage
                .status(HttpStatusExtractorUtils.extract(ex).value())
                .code(ex.getCode())
                .message(messageSourceAccessor.getMessage(ex.getCode()))
                .dateTime(OffsetDateTime.now(clock))
                .build();
    }
}
