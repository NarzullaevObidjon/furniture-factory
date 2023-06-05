package com.company.furniturefactory.dto.materialIncome;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MaterialInResponse {
    private Long id;
    private String materialName;
    private String supplierName;
    private String measurementName;
    private Double price;
    private Double amount;
    private LocalDateTime incomeDate;

}
