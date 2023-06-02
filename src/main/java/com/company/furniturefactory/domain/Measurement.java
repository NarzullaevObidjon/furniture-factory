package com.company.furniturefactory.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Measurement extends Auditable{
    Long id;
    String nameUz;
    String nameRu;

    @Builder(builderMethodName = "childBuilder")
    public Measurement(Long updatedBy, Long createdBy, Long deletedBy, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, boolean deleted, Long authUserId, String firstName, String lastName, String phone) {
        super(updatedBy, createdBy, deletedBy, createdAt, updatedAt, deletedAt, deleted);
        this.nameUz = nameUz;
        this.id = id;
        this.nameRu = nameRu;
    }
}
