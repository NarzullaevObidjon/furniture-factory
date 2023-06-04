package com.company.furniturefactory.dto.material;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MaterialResponse {
   private Long id;
   private String code;
   private Integer norma;
   private String nameUz;
   private String nameRu;
   private Long measurementId;
   private Long imageId;
   private String imagePath;
   private String measurementName;
}
