package com.mycompany.fieldofstudyservice;

import com.mycompany.fieldofstudyservice.models.Department;
import com.mycompany.fieldofstudyservice.models.FieldOfStudy;
import com.mycompany.fieldofstudyservice.services.DepartmentService;
import com.mycompany.fieldofstudyservice.services.FieldOfStudyService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FieldOfStudyServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FieldOfStudyServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner run(FieldOfStudyService fieldOfStudyService,
                          DepartmentService departmentService){
        return args -> {
            FieldOfStudy fieldOfStudy1 = FieldOfStudy
                    .builder()
                    .id(1L)
                    .fieldName("Law")
                    .description("test")
                    .build();
            FieldOfStudy fieldOfStudy2 = FieldOfStudy
                    .builder()
                    .id(2L)
                    .fieldName("Engineering")
                    .description("test")
                    .build();
            Department department1 =
                    Department.builder()
                            .id(1L)
                            .departmentName("Civil")
                            .fieldOfStudyId(2L)
                            .description("test")
                            .build();
            Department department2 =
                    Department.builder()
                            .id(2L)
                            .departmentName("criminal law")
                            .fieldOfStudyId(1L)
                            .description("test")
                            .build();
            fieldOfStudyService.save(fieldOfStudy1);
            fieldOfStudyService.save(fieldOfStudy2);
            departmentService.save(department1);
            departmentService.save(department2);

        };
    }
}
