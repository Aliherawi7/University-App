package com.mycompany;

import com.mycompany.constants.Gender;
import com.mycompany.models.Student;
import com.mycompany.repositories.StudentRepository;
import com.mycompany.services.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;


@SpringBootApplication
public class StudentApplication {
    public static void main(String[] args) {
        SpringApplication.run(StudentApplication.class, args);
    }


    @Bean
    CommandLineRunner run(StudentRepository studentRepository){
        return args -> {
            Student student = Student.builder()
                    .name("ahmad")
                    .id(1L)
                    .departmentId(1L)
                    .fieldOfStudyId(2L)
                    .dob(LocalDate.now())
                    .gender(Gender.MALE)
                    .joinedDate(LocalDate.now())
                    .email("ahmad@gmail.com")
                    .phoneNumber("4235234234")
                    .lastName("ahmadi")
                    .location("AFG")
                    .nationalId("32634523")
                    .nationality("Afghan")
                    .password("12345")
                    .build();
            studentRepository.save(student);
        };
    }
}
