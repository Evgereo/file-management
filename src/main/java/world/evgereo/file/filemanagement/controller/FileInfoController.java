package world.evgereo.file.filemanagement.controller;

import static world.evgereo.file.filemanagement.constants.EndpointConstants.FILE_ENDPOINT;
import static world.evgereo.file.filemanagement.constants.SwaggerConstants.OK;
import static world.evgereo.file.filemanagement.constants.SwaggerConstants.SUCCESSFUL_OPERATION;
import static world.evgereo.file.filemanagement.constants.ValidationConstants.MAX_NAME_SIZE;
import static world.evgereo.file.filemanagement.constants.ValidationConstants.MAX_PAGE_SIZE;
import static world.evgereo.file.filemanagement.constants.ValidationConstants.MIN_NAME_SIZE;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import world.evgereo.file.filemanagement.dto.FileInfoDto;
import world.evgereo.file.filemanagement.dto.PageDto;

@Tag(name = "File controller")
public interface FileInfoController {

    @Operation(
            summary = "Get page of files info",
            responses = @ApiResponse(
                    description = SUCCESSFUL_OPERATION,
                    responseCode = OK
            )
    )
    @GetMapping(FILE_ENDPOINT)
    PageDto<FileInfoDto> findAll(@PathVariable @Size(min = MIN_NAME_SIZE, max = MAX_NAME_SIZE) String bucketName,
                                 @RequestParam(required = false, defaultValue = "0") @PositiveOrZero int pageNumber,
                                 @RequestParam(required = false, defaultValue = "10") @Positive @Max(MAX_PAGE_SIZE) int pageSize);

    @Operation(
            summary = "Get file info by name",
            responses = @ApiResponse(
                    description = SUCCESSFUL_OPERATION,
                    responseCode = OK
            )
    )
    @GetMapping(FILE_ENDPOINT + "/{fileName}")
    FileInfoDto getByName(@PathVariable @Size(min = MIN_NAME_SIZE, max = MAX_NAME_SIZE) String bucketName,
                          @PathVariable @Size(min = MIN_NAME_SIZE, max = MAX_NAME_SIZE) String fileName);
}
