package com.company.furniturefactory.service;

import com.company.furniturefactory.dao.AuthUserDAO;
import com.company.furniturefactory.domain.AuthUser;
import com.company.furniturefactory.domain.Product;
import com.company.furniturefactory.dto.response.UserResponse;
import com.company.furniturefactory.dto.user.UserCreateDTO;
import com.company.furniturefactory.dto.user.UserCreateIdDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final AuthUserDAO authUserDAO;
    private final ImageService imageService;

    public List<UserResponse> getAll() {
        return authUserDAO.getAll();
    }

    public void add(UserCreateDTO dto) {
        Long imageId = null;
        if (!dto.getImage().isEmpty()) {
            imageId = imageService.loadImage(dto.getImage());
        }

        AuthUser user = new AuthUser();

        setUsernameAndPassword(dto,user);

        user.setImageId(imageId);
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getFirstName());
        user.setPhone(dto.getPhone());
        user.setRole(dto.getRole());

        authUserDAO.save(user);
    }

    public void update(UserCreateIdDTO dto) {
        AuthUser user = AuthUser.childBuilder()
                .id(dto.getId())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .role(dto.getRole())
                .phone(dto.getPhone())
                .build();

        Long imageId;
        if (!dto.getImage().isEmpty()) {
            imageId = imageService.loadImage(dto.getImage());
        }else {
            imageId = authUserDAO.getImageId(user.getId());
        }
        user.setImageId(imageId);
        authUserDAO.update(user);
    }

    public void delete(Long id) {
        authUserDAO.delete(id);
    }

    private void setUsernameAndPassword(UserCreateDTO dto, AuthUser user) {
        user.setUsername(dto.getPhone().substring(1));
        user.setPassword(dto.getFirstName().replaceAll("[^a-zA-Z0-9]",""));
    }
}
