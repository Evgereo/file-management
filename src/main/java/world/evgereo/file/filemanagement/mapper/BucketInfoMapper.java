package world.evgereo.file.filemanagement.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import world.evgereo.file.filemanagement.config.MapStructConfig;
import world.evgereo.file.filemanagement.dto.BucketCreateRq;
import world.evgereo.file.filemanagement.dto.BucketInfoDto;
import world.evgereo.file.filemanagement.model.BucketInfo;

@Mapper(config = MapStructConfig.class, uses = FileInfoMapper.class)
public interface BucketInfoMapper {

    @Mapping(target = "space", ignore = true)
    @Mapping(target = "filesInfo", ignore = true)
    @Mapping(target = "remainingSpace", ignore = true) //TODO add functionality
    BucketInfo convert(BucketCreateRq source);

    BucketInfoDto convert(BucketInfo source);
}
