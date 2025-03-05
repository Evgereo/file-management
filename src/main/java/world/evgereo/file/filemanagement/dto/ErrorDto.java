package world.evgereo.file.filemanagement.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.Builder;
import org.springframework.format.annotation.DateTimeFormat;

@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(title = "Error")
public record ErrorDto(
        @NotNull
        @Schema(title = "Identifier")
        UUID id,

        @NotNull
        @Schema(title = "HTTP status")
        Integer status,

        @NotBlank
        @Schema(title = "Error code")
        String code,

        @NotBlank
        @Schema(title = "Message")
        String message,

        @Schema(title = "Error details")
        Object data,

        @NotNull
        @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        @Schema(title = "Date and time", example = "2012-12-12T00:00:00-05")
        OffsetDateTime dateTime
) {
}
