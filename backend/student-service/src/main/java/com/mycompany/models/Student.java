package com.mycompany.models;

import com.mycompany.constants.Gender;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor()
@Getter
@Setter
@Data
@Builder
public class Student {
    @Id
    @SequenceGenerator(name = "student-sequence", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student-sequence")
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

