package world.evgereo.file.filemanagement.dto;

import static world.evgereo.file.filemanagement.constants.ValidationConstants.MAX_PAGE_SIZE;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import java.util.Collection;
import lombok.Builder;

@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(title = "Paginated data")
public record PageDto<T>(

        @PositiveOrZero
        @Schema(title = "Page number")
        int pageNumber,

        @Max(MAX_PAGE_SIZE)
        @Positive
        @Schema(title = "Number of elements on a page")
        int pageSize,

        @PositiveOrZero
        @Schema(title = "Total number of pages")
        int totalPage,

        @PositiveOrZero
        @Schema(title = "Total number of elements")
        long totalCount,

        @NotNull
        @Schema(title = "Content")
        Collection<T> content
) {
}
