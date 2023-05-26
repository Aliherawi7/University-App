package com.mycompany.dto;

import com.mycompany.constants.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class StudentDTO {
    private String name;
    private String lastName;
    private String email;
    private String imageUrl;
    private LocalDate dob;
    private String nationality;
    private String phoneNumber;
    private Gender gender;
    private LocalDate joinedDate;
    private String nationalId;
    private String location;
    private String fieldOfStudy;
    private String departmentName;
}
