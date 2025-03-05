package world.evgereo.file.filemanagement.dto;

import static world.evgereo.file.filemanagement.constants.ValidationConstants.MAX_NAME_SIZE;
import static world.evgereo.file.filemanagement.constants.ValidationConstants.MIN_NAME_SIZE;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(title = "File notification message")
public record FileNotificationMessageDto(

        @NotBlank
        @Size(min = MIN_NAME_SIZE, max = MAX_NAME_SIZE)
        @Schema(title = "Name of bucket")
        String bucketName,

        @NotBlank
        @Size(min = MIN_NAME_SIZE, max = MAX_NAME_SIZE)
        @Schema(title = "Name of file")
        String fileName,

        @NotNull
        @Positive
        @Schema(title = "Size of file")
        Long size,

        @NotNull
        @Positive
        @Schema(title = "Remaining space in the bucket")
        Long remainingSpace,

        @NotBlank
        @Size(max = 255)
        @Schema(title = "Message")
        String message
) {
}
