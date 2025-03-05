package world.evgereo.file.filemanagement.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import world.evgereo.file.filemanagement.controller.BucketController;
import world.evgereo.file.filemanagement.dto.BucketCreateRq;
import world.evgereo.file.filemanagement.dto.BucketInfoDto;
import world.evgereo.file.filemanagement.mapper.BucketInfoMapper;
import world.evgereo.file.filemanagement.service.BucketInfoService;
import world.evgereo.file.filemanagement.usecase.BucketCreateUseCase;
import world.evgereo.file.filemanagement.usecase.BucketDropUseCase;

@RestController
@RequiredArgsConstructor
public class BucketControllerImpl implements BucketController {
    private final BucketCreateUseCase bucketCreateUseCase;
    private final BucketDropUseCase bucketDropUseCase;
    private final BucketInfoService service;
    private final BucketInfoMapper mapper;

    @Override
    public BucketInfoDto getByName(String bucketName) {
        return mapper.convert(service.get(bucketName));
    }

    @Override
    public BucketInfoDto create(BucketCreateRq rq) {
        return mapper.convert(
                bucketCreateUseCase.create(mapper.convert(rq))
        );
    }

    @Override
    public void drop(String bucketName) {
        bucketDropUseCase.drop(bucketName);
    }
}
