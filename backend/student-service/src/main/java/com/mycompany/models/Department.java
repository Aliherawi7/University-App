package com.mycompany.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Department {
    private Long id;
    private Long fieldOfStudyId;
    private String departmentName;
    private String description;
}
