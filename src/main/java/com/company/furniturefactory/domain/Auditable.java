package com.company.furniturefactory.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Auditable {
   private Long updatedBy;
   private Long createdBy;
   private Long deletedBy;
   private LocalDateTime createdAt;
   private LocalDateTime updatedAt;
   private LocalDateTime deletedAt;
   private boolean deleted;
}
