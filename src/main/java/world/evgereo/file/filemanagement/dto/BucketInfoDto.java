package world.evgereo.file.filemanagement.dto;

import static world.evgereo.file.filemanagement.constants.ValidationConstants.MAX_NAME_SIZE;
import static world.evgereo.file.filemanagement.constants.ValidationConstants.MIN_NAME_SIZE;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(title = "Bucket information")
public record BucketInfoDto(

        @NotBlank
        @Size(min = MIN_NAME_SIZE, max = MAX_NAME_SIZE)
        @Schema(title = "Name")
        String name,

        @NotNull
        @Positive
        @Schema(title = "Space of bucket")
        Long space,

        @NotNull
        @Positive
        @Schema(title = "Remaining space of the bucket")
        Long remainingSpace,

        @Size(max = 100)
        @Schema(title = "Files information in the bucket")
        List<@Valid @NotNull FileInfoDto> filesInfo
) {
}
