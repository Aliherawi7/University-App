package com.mycompany.models;

import com.mycompany.constants.Degree;
import com.mycompany.constants.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Teacher {
    @Id
    @SequenceGenerator(name = "teacher_sequence", sequenceName = "teacher_sequence", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_sequence")
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private LocalDate dob;
    private String nationalId;
    private String phoneNumber;
    private Gender gender;
    private Degree degree;
    private int experience;
    private Long fieldOfStudyId;
    private Long departmentId;
    private LocalDate jointedDate;
    private Long salary;

}
