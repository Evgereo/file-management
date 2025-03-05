package world.evgereo.file.filemanagement.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ErrorCodeConstants {
    public static final String BUCKET_INFO_NOT_FOUND_ERROR = "bucket.info.not_found";
    public static final String FILE_INFO_NOT_FOUND_ERROR = "file.info.not_found";
    public static final String FILE_INFO_ALREADY_EXISTS_ERROR = "file.info.already_exists";
}
