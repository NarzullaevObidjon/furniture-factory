package com.company.furniturefactory.domain;

import com.company.furniturefactory.enums.Role;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthUser {
    Long id;
    String username;
    String password;
    @Builder.Default
    Role role = Role.COORDINATOR;
    boolean deleted;
}
