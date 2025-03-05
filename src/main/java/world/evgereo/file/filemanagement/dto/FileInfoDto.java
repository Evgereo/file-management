package world.evgereo.file.filemanagement.dto;

import static world.evgereo.file.filemanagement.constants.ValidationConstants.MAX_NAME_SIZE;
import static world.evgereo.file.filemanagement.constants.ValidationConstants.MIN_NAME_SIZE;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.util.UUID;
import lombok.Builder;

@Builder(toBuilder = true)
@Schema(title = "File information")
public record FileInfoDto(
        @NotNull
        @Schema(title = "Identifier")
        UUID id,

        @NotBlank
        @Size(min = MIN_NAME_SIZE, max = MAX_NAME_SIZE)
        @Schema(title = "Bucket name")
        String bucketName,

        @NotBlank
        @Size(min = MIN_NAME_SIZE, max = MAX_NAME_SIZE)
        @Schema(title = "File name")
        String fileName,

        @NotNull
        @Positive
        @Schema(title = "Size of file")
        Long size
) {
}
