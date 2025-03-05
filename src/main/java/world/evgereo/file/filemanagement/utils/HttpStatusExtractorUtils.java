package world.evgereo.file.filemanagement.utils;

import java.util.Optional;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import world.evgereo.file.filemanagement.exception.AbstractFileManagementException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HttpStatusExtractorUtils {

    public static HttpStatus extract(AbstractFileManagementException ex) {
        var responseStatus = ex.getClass().getAnnotation(ResponseStatus.class);
        return Optional.ofNullable(responseStatus)
                .map(ResponseStatus::value)
                .orElse(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
