package com.company.furniturefactory.dto.product;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductCreateDTO {
    @NotBlank(message = "Name uz must not be empty")
    private String nameUz;
    @NotBlank(message = "Name ru must not be empty")
    private String nameRu;
    private Long categoryId;
    private MultipartFile image;
}