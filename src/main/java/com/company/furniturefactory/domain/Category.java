package com.company.furniturefactory.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Category extends Auditable{
    Long id;
    String nameUz;
    String nameRu;

    @Builder(builderMethodName = "childBuilder")

    public Category(Long updatedBy, Long createdBy, Long deletedBy, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, boolean deleted, Long id, String nameUz, String nameRu) {
        super(updatedBy, createdBy, deletedBy, createdAt, updatedAt, deletedAt, deleted);
        this.id = id;
        this.nameUz = nameUz;
        this.nameRu = nameRu;
    }
}
