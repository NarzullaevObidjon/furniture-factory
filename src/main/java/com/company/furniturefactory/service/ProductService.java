package com.company.furniturefactory.service;

import com.company.furniturefactory.dao.ProductDAO;
import com.company.furniturefactory.domain.Material;
import com.company.furniturefactory.domain.Product;
import com.company.furniturefactory.dto.product.ProductCreateDTO;
import com.company.furniturefactory.dto.product.ProductCreateIdDTO;
import com.company.furniturefactory.dto.product.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductDAO productDAO;
    private final ImageService imageService;

    public List<ProductResponse> getAll() {
        return productDAO.getAll();
    }

    public void add(ProductCreateDTO dto) {
        Long imageId = null;
        if (!dto.getImage().isEmpty()) {
            imageId = imageService.loadImage(dto.getImage());
        }

        productDAO.save(
                Product.childBuilder()
                        .nameRu(dto.getNameRu())
                        .nameUz(dto.getNameUz())
                        .categoryId(dto.getCategoryId())
                        .imageId(imageId)
                        .build()
        );
    }

    public void update(ProductCreateIdDTO dto) {
        Product product = Product.childBuilder()
                .id(dto.getId())
                .nameUz(dto.getNameUz())
                .nameRu(dto.getNameRu())
                .categoryId(dto.getCategoryId())
                .build();

        Long imageId;
        if (!dto.getImage().isEmpty()) {
            imageId = imageService.loadImage(dto.getImage());
        }else {
            imageId = productDAO.getImageId(product.getId());
        }
        product.setImageId(imageId);
        productDAO.update(product);
    }

    public void delete(Long id) {
        productDAO.delete(id);
    }
}

