package com.company.furniturefactory.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Client extends Auditable{
    Long id;
    String name;
    String phone;

    @Builder(builderMethodName = "childBuilder")

    public Client(Long updatedBy, Long createdBy, Long deletedBy, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, boolean deleted, Long id, String name, String phone) {
        super(updatedBy, createdBy, deletedBy, createdAt, updatedAt, deletedAt, deleted);
        this.id = id;
        this.name = name;
        this.phone = phone;
    }
}
