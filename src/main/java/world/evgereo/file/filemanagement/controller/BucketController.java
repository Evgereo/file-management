package world.evgereo.file.filemanagement.controller;

import static world.evgereo.file.filemanagement.constants.EndpointConstants.BUCKET_ENDPOINT;
import static world.evgereo.file.filemanagement.constants.SwaggerConstants.CREATED;
import static world.evgereo.file.filemanagement.constants.SwaggerConstants.CREATED_OPERATION;
import static world.evgereo.file.filemanagement.constants.SwaggerConstants.NO_CONTENT;
import static world.evgereo.file.filemanagement.constants.SwaggerConstants.NO_CONTENT_OPERATION;
import static world.evgereo.file.filemanagement.constants.SwaggerConstants.OK;
import static world.evgereo.file.filemanagement.constants.SwaggerConstants.SUCCESSFUL_OPERATION;
import static world.evgereo.file.filemanagement.constants.ValidationConstants.MAX_NAME_SIZE;
import static world.evgereo.file.filemanagement.constants.ValidationConstants.MIN_NAME_SIZE;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import world.evgereo.file.filemanagement.dto.BucketCreateRq;
import world.evgereo.file.filemanagement.dto.BucketInfoDto;

@Tag(name = "Bucket controller")
public interface BucketController {

    @Operation(
            summary = "Get bucket info by name",
            responses = @ApiResponse(
                    description = SUCCESSFUL_OPERATION,
                    responseCode = OK
            )
    )
    @GetMapping(BUCKET_ENDPOINT + "/{bucketName}")
    BucketInfoDto getByName(@PathVariable @Size(min = MIN_NAME_SIZE, max = MAX_NAME_SIZE) String bucketName);

    @Operation(
            summary = "Create bucket",
            responses = @ApiResponse(
                    description = CREATED_OPERATION,
                    responseCode = CREATED
            )
    )
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(BUCKET_ENDPOINT)
    BucketInfoDto create(@RequestBody @Valid BucketCreateRq rq);

    @Operation(
            summary = "Drop bucket",
            responses = @ApiResponse(
                    description = NO_CONTENT_OPERATION,
                    responseCode = NO_CONTENT
            )
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(BUCKET_ENDPOINT + "/{bucketName}")
    void drop(@PathVariable @Size(min = MIN_NAME_SIZE, max = MAX_NAME_SIZE) String bucketName);
}
