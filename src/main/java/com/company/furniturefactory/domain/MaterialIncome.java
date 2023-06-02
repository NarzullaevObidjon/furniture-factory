package com.company.furniturefactory.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MaterialIncome{
    Long id;
    Long materialId;
    Long supplierId;
    Double amount;
    Double price;
    LocalDateTime incomeDate;
    Long createdBy;
    LocalDateTime createdAt;
}
