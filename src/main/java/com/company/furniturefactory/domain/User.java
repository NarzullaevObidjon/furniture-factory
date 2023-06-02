package com.company.furniturefactory.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User extends Auditable{
    Long id;
    Long authUserId;
    String firstName;
    String lastName;
    String phone;

    @Builder(builderMethodName = "childBuilder")
    public User(Long updatedBy, Long createdBy, Long deletedBy, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, boolean deleted, Long authUserId, String firstName, String lastName, String phone) {
        super(updatedBy, createdBy, deletedBy, createdAt, updatedAt, deletedAt, deleted);
        this.authUserId = authUserId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.id = id;
    }
}
