package world.evgereo.file.filemanagement.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class EndpointConstants {
    private static final String API = "/api";
    private static final String V1 = "/v1";

    public static final String BUCKET_ENDPOINT = API + V1 + "/buckets";
    public static final String FILE_ENDPOINT = API + V1 + "/buckets/{bucketName}/files";
    public static final String STORAGE_ENDPOINT = API + V1 + "/storage/buckets/{bucketName}/files";

    // WebSocket
    public static final String CONNECTION_ENDPOINT = "/notification";
    public static final String FILE_BROKER_ENDPOINT = "/file-messages";
}
