package com.company.furniturefactory.dto.category;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryWithIdDTO {
    private Long id;
    @NotBlank(message = "Name uz must not be empty")
    private String nameUz;
    @NotBlank(message = "Name ru must not be empty")
    private String nameRu;
}
