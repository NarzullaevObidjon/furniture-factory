package com.company.furniturefactory.domain;

import com.company.furniturefactory.enums.Role;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthUser extends Auditable{
    Long id;
    String username;
    String password;
    @Builder.Default
    Role role = Role.COORDINATOR;
    boolean deleted;
    String firstName;
    String lastName;
    String phone;
    Long imageId;

    @Builder(builderMethodName = "childBuilder")

    public AuthUser(Long updatedBy, Long createdBy, Long deletedBy, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, boolean deleted, Long id, String username, String password, Role role, boolean deleted1, String firstName, String lastName, String phone, Long imageId) {
        super(updatedBy, createdBy, deletedBy, createdAt, updatedAt, deletedAt, deleted);
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.deleted = deleted1;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.imageId = imageId;
    }
}
