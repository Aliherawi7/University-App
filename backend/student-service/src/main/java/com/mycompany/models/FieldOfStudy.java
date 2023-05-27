package com.mycompany.models;

import jakarta.persistence.Entity;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FieldOfStudy {
    private long id;
    private String fieldName;
    private String description;
}
