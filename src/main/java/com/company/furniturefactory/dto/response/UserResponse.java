package com.company.furniturefactory.dto.response;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserResponse {
    private String id;
    private String firstName;
    private String lastName;
    private String role;
    private String phone;
    private String ImageUrl;
}
