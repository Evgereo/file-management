package world.evgereo.file.filemanagement.utils;

import io.minio.GetObjectArgs;
import io.minio.MakeBucketArgs;
import io.minio.PutObjectArgs;
import io.minio.RemoveBucketArgs;
import io.minio.RemoveObjectArgs;
import java.io.InputStream;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MinioRequestUtils {

    public static GetObjectArgs buildGetRequest(String bucketName, String fileName) {
        return GetObjectArgs.builder()
                .bucket(bucketName)
                .object(fileName)
                .build();
    }

    @SneakyThrows
    public static PutObjectArgs buildPutRequest(String bucketName, MultipartFile file, InputStream stream) {
        var allPartSize = -1;
        return PutObjectArgs.builder()
                .bucket(bucketName)
                .object(file.getOriginalFilename())
                .stream(stream, stream.available(), allPartSize)
                .contentType(file.getContentType())
                .build();
    }

    public static RemoveObjectArgs buildDeleteRequest(String bucketName, String fileName) {
        return RemoveObjectArgs.builder()
                .bucket(bucketName)
                .object(fileName)
                .build();
    }

    public static MakeBucketArgs buildCreateBucketRequest(String bucketName) {
        return MakeBucketArgs.builder()
                .bucket(bucketName)
                .build();
    }

    public static RemoveBucketArgs buildDropBucketRequest(String bucketName) {
        return RemoveBucketArgs.builder()
                .bucket(bucketName)
                .build();
    }
}
