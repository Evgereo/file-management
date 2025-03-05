package world.evgereo.file.filemanagement.controller;

import static world.evgereo.file.filemanagement.constants.EndpointConstants.STORAGE_ENDPOINT;
import static world.evgereo.file.filemanagement.constants.SwaggerConstants.ACCEPTED;
import static world.evgereo.file.filemanagement.constants.SwaggerConstants.ACCEPTED_OPERATION;
import static world.evgereo.file.filemanagement.constants.SwaggerConstants.NO_CONTENT;
import static world.evgereo.file.filemanagement.constants.SwaggerConstants.NO_CONTENT_OPERATION;
import static world.evgereo.file.filemanagement.constants.SwaggerConstants.OK;
import static world.evgereo.file.filemanagement.constants.SwaggerConstants.SUCCESSFUL_OPERATION;
import static world.evgereo.file.filemanagement.constants.ValidationConstants.MAX_NAME_SIZE;
import static world.evgereo.file.filemanagement.constants.ValidationConstants.MIN_NAME_SIZE;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.constraints.Size;
import org.junit.jupiter.api.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

@Tag("Storage controller")
public interface FileStorageController {

    @Operation(
            summary = "Download file",
            responses = @ApiResponse(
                    description = SUCCESSFUL_OPERATION,
                    responseCode = OK
            )
    )
    @GetMapping(STORAGE_ENDPOINT + "/{fileName}")
    StreamingResponseBody download(@PathVariable @Size(min = MIN_NAME_SIZE, max = MAX_NAME_SIZE) String bucketName,
                                   @PathVariable @Size(min = MIN_NAME_SIZE, max = MAX_NAME_SIZE) String fileName);

    @Operation(
            summary = "Upload file",
            responses = @ApiResponse(
                    description = ACCEPTED_OPERATION,
                    responseCode = ACCEPTED
            )
    )
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping(STORAGE_ENDPOINT)
    void upload(@PathVariable @Size(min = MIN_NAME_SIZE, max = MAX_NAME_SIZE) String bucketName,
                @RequestPart("file") MultipartFile file);

    @Operation(
            summary = "Delete file",
            responses = @ApiResponse(
                    description = NO_CONTENT_OPERATION,
                    responseCode = NO_CONTENT
            )
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(STORAGE_ENDPOINT + "/{fileName}")
    void delete(@PathVariable @Size(min = MIN_NAME_SIZE, max = MAX_NAME_SIZE) String bucketName,
                @PathVariable @Size(min = MIN_NAME_SIZE, max = MAX_NAME_SIZE) String fileName);
}
