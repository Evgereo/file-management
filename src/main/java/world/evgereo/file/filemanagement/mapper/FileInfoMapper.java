package world.evgereo.file.filemanagement.mapper;

import world.evgereo.file.filemanagement.config.MapStructConfig;
import world.evgereo.file.filemanagement.dto.FileInfoDto;
import world.evgereo.file.filemanagement.model.FileInfo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(config = MapStructConfig.class)
public interface FileInfoMapper {

    FileInfoDto convert(FileInfo source);

    List<FileInfoDto> convert(List<FileInfo> source);
}
