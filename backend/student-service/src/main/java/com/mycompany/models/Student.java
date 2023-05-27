package com.mycompany.models;

import com.mycompany.constants.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Student {

    @Id
    @SequenceGenerator(name = "student_sequence", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    private Long id;
    private String name;
    private String lastName;
    private LocalDate dob;
    private String nationality;
    private String phoneNumber;
    private Gender gender;
    private LocalDate joinedDate;
    private String nationalId;
    private String imageUrl;
    private String location;
    private Long fieldOfStudyId;
    private Long departmentId;
    private String email;
    private String password;
}

