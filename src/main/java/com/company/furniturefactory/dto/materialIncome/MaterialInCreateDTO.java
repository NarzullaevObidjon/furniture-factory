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
public class MaterialInCreateDTO {
    private Long materialId;
    private Long supplierId;
    private Double amount;
    private Double price;
    private LocalDateTime incomeDate;
}
