package com.company.furniturefactory.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product extends Auditable{
    Long id;
    String nameUz;
    String nameRu;
    Long categoryId;
    Long imageId;

    @Builder(builderMethodName = "childBuilder")

    public Product(Long updatedBy, Long createdBy, Long deletedBy, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, boolean deleted, Long id, String nameUz, String nameRu, Long categoryId, Long imageId) {
        super(updatedBy, createdBy, deletedBy, createdAt, updatedAt, deletedAt, deleted);
        this.id = id;
        this.nameUz = nameUz;
        this.nameRu = nameRu;
        this.categoryId = categoryId;
        this.imageId = imageId;
    }
}
