package com.company.furniturefactory.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MaterialOutcome {
    Long id;
    Long materialId;
    Double amount;
    Double price;
    LocalDateTime outcomeDate;
    Long createdBy;
    LocalDateTime createdAt;
}
