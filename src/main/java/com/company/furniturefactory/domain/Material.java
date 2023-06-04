package com.company.furniturefactory.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Material extends Auditable{
    Long id;
    String code;
    Integer norma;
    String nameUz;
    String nameRu;
    Long measurementId;
    Long imageId;

    @Builder(builderMethodName = "childBuilder")
    public Material(Long updatedBy, Long createdBy, Long deletedBy, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, boolean deleted, Long id, String code, Integer norma, String nameUz, String nameRu, Long measurementId, Long imageId) {
        super(updatedBy, createdBy, deletedBy, createdAt, updatedAt, deletedAt, deleted);
        this.id = id;
        this.code = code;
        this.norma = norma;
        this.nameUz = nameUz;
        this.nameRu = nameRu;
        this.measurementId = measurementId;
        this.imageId = imageId;
    }
}
