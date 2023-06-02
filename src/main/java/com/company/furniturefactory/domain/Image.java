package com.company.furniturefactory.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Image extends Auditable{
    Long id;
    String generatedFileName;
    String originalFileName;
    String filePath;
    String mimeType;
    String extension;
    Long size;

    @Builder(builderMethodName = "childBuilder")
    public Image(Long updatedBy, Long createdBy, Long deletedBy, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, boolean deleted, Long id, String generatedFileName, String originalFileName, String filePath, String mimeType, String extension, Long size) {
        super(updatedBy, createdBy, deletedBy, createdAt, updatedAt, deletedAt, deleted);
        this.id = id;
        this.generatedFileName = generatedFileName;
        this.originalFileName = originalFileName;
        this.filePath = filePath;
        this.mimeType = mimeType;
        this.extension = extension;
        this.size = size;
    }
}
