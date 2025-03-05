package world.evgereo.file.filemanagement.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Document
public class BucketInfo {

    @Id
    private String name;

    private long space;

    private long remainingSpace;

    @DBRef
    private List<FileInfo> filesInfo;
}
