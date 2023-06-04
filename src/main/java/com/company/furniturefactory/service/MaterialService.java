package com.company.furniturefactory.service;

import com.company.furniturefactory.dao.MaterialDAO;
import com.company.furniturefactory.domain.Material;
import com.company.furniturefactory.dto.material.MaterialCreateDTO;
import com.company.furniturefactory.dto.material.MaterialCreateIdDTO;
import com.company.furniturefactory.dto.material.MaterialResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MaterialService {
    private final MaterialDAO materialDAO;
    private final ImageService imageService;

    public List<MaterialResponse> getAll() {
        return materialDAO.getAll();
    }

    public void add(MaterialCreateDTO dto) {

        Long imageId = null;
        if (!dto.getImage().isEmpty()) {
            imageId = imageService.loadImage(dto.getImage());
        }

        materialDAO.save(
                Material.childBuilder()
                        .code(dto.getCode())
                        .nameRu(dto.getNameRu())
                        .nameUz(dto.getNameUz())
                        .norma(dto.getNorma())
                        .measurementId(dto.getMeasurementId())
                        .imageId(imageId)
                        .build()
        );
    }

    public void update(MaterialCreateIdDTO dto) {
        Material material = Material.childBuilder()
                .id(dto.getId())
                .code(dto.getCode())
                .norma(dto.getNorma())
                .nameUz(dto.getNameUz())
                .nameRu(dto.getNameRu())
                .measurementId(dto.getMeasurementId())
                .build();
        Long imageId;
        if (!dto.getImage().isEmpty()) {
            imageId = imageService.loadImage(dto.getImage());
        }else {
            imageId = materialDAO.getImageId(material.getId());
        }
        material.setImageId(imageId);
        materialDAO.update(material);
    }

    public void delete(Long id) {
        materialDAO.delete(id);
    }
}
