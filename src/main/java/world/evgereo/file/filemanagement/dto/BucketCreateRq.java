package world.evgereo.file.filemanagement.dto;

import static world.evgereo.file.filemanagement.constants.ValidationConstants.MAX_NAME_SIZE;
import static world.evgereo.file.filemanagement.constants.ValidationConstants.MIN_NAME_SIZE;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder(toBuilder = true)
@Schema(title = "Request for creation of bucket")
public record BucketCreateRq(

        @NotBlank
        @Size(min = MIN_NAME_SIZE, max = MAX_NAME_SIZE)
        @Schema(title = "Name")
        String name,

        @NotNull
        @Positive
        @Schema(title = "Desired space")
        Long desiredSpace
) {
}
