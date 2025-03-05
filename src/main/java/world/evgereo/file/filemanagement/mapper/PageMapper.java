package world.evgereo.file.filemanagement.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;
import world.evgereo.file.filemanagement.config.MapStructConfig;
import world.evgereo.file.filemanagement.dto.FileInfoDto;
import world.evgereo.file.filemanagement.dto.PageDto;
import world.evgereo.file.filemanagement.model.FileInfo;

@Mapper(config = MapStructConfig.class, uses = FileInfoMapper.class)
public interface PageMapper {

    @Mapping(target = "pageSize", source = "size")
    @Mapping(target = "pageNumber", source = "number")
    @Mapping(target = "totalPage", source = "totalPages")
    @Mapping(target = "totalCount", source = "totalElements")
    PageDto<FileInfoDto> toFileInfoDto(Page<FileInfo> source);
}
