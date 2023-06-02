package com.company.furniturefactory.domain;

import com.company.furniturefactory.enums.Role;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
public class AuthUser {
    Long id;
    String username;
    String password;
    @Builder.Default
    Role role = Role.COORDINATOR;
    boolean deleted;
}
