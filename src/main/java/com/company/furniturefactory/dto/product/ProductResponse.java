package com.company.furniturefactory.dto.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponse {
    private Long id;
    private String nameUz;
    private String nameRu;
    private Long categoryId;
    private Long imageId;
    private String imagePath;
    private String categoryName;
}