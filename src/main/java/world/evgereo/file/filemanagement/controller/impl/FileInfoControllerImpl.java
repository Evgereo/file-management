package world.evgereo.file.filemanagement.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import world.evgereo.file.filemanagement.controller.FileInfoController;
import world.evgereo.file.filemanagement.dto.FileInfoDto;
import world.evgereo.file.filemanagement.dto.PageDto;
import world.evgereo.file.filemanagement.mapper.FileInfoMapper;
import world.evgereo.file.filemanagement.mapper.PageMapper;
import world.evgereo.file.filemanagement.service.FileInfoService;

@RestController
@RequiredArgsConstructor
public class FileInfoControllerImpl implements FileInfoController {
    private final FileInfoMapper fileInfoMapper;
    private final FileInfoService service;
    private final PageMapper pageMapper;

    @Override
    public PageDto<FileInfoDto> findAll(String bucketName, int pageNumber, int pageSize) {
        return pageMapper.toFileInfoDto(service.findAll(bucketName, pageNumber, pageSize));
    }

    @Override
    public FileInfoDto getByName(String bucketName, String fileName) {
        return fileInfoMapper.convert(service.get(bucketName, fileName));
    }
}
