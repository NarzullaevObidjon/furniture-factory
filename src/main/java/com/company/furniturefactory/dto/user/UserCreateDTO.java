package com.company.furniturefactory.dto.user;

import com.company.furniturefactory.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCreateDTO {
    private String phone;
    private String firstName;
    private String lastName;
    private Role role;
    private MultipartFile image;
}
