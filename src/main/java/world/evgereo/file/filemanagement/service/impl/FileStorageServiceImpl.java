package world.evgereo.file.filemanagement.service.impl;

import static world.evgereo.file.filemanagement.constants.StorageConstants.DEFAULT_STREAM_OFFSET;
import static world.evgereo.file.filemanagement.constants.StorageConstants.END_OF_BYTES;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.function.Failable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;
import world.evgereo.file.filemanagement.service.FileStorageService;
import world.evgereo.file.filemanagement.utils.MinioRequestUtils;
import world.evgereo.spring.minio.service.MinioService;

@Service
@RequiredArgsConstructor
public class FileStorageServiceImpl implements FileStorageService {
    private final MinioService minioService;

    @Override
    public StreamingResponseBody get(String bucketName, String fileName) {
        return outputStream -> {
            try (var inputStream = minioService.getObject(MinioRequestUtils.buildGetRequest(bucketName, fileName))) {
                var data = new byte[1024]; // 128KB
                var numberOfBytesToWrite = 0;
                while ((numberOfBytesToWrite = inputStream.read(data, DEFAULT_STREAM_OFFSET, data.length)) != END_OF_BYTES) {
                    outputStream.write(data, DEFAULT_STREAM_OFFSET, numberOfBytesToWrite);
                }
            }
        };
    }

    @Override
    public void put(String bucketName, MultipartFile file) {
        Failable.asRunnable(() ->
                minioService.putObject(MinioRequestUtils.buildPutRequest(bucketName, file, file.getInputStream()))
        ).run();
    }

    @Override
    public void delete(String bucketName, String fileName) {
        minioService.removeObject(MinioRequestUtils.buildDeleteRequest(bucketName, fileName));
    }
}
