package world.evgereo.file.filemanagement.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MessageConstants {
    public static final String SUCCESSFUL_NOTIFICATION = "File %s was successfully uploaded";
    public static final String FAILED_NOTIFICATION = "File %s failed to uploaded";
}
