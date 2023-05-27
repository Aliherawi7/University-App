package com.mycompany.services;

import com.mycompany.dto.StudentDTO;
import com.mycompany.dto.StudentReqisterationRequest.StudentRegistrationRequest;
import com.mycompany.exceptions.ResourceNotFoundException;
import com.mycompany.models.Department;
import com.mycompany.models.FieldOfStudy;
import com.mycompany.models.Student;
import com.mycompany.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class StudentService {

    private final StudentRepository studentRepository;
    private final RestTemplate restTemplate;

    public StudentDTO getStudentDetails(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        FieldOfStudy fieldOfStudy;
        Department department;
        if (student.isEmpty()) {
            log.info("student not found with provided id: {}",id);
            throw new ResourceNotFoundException("student not found with provided id: "+id);
        }
        fieldOfStudy = restTemplate.getForObject("http://localhost:8083/api/v1/field-of-studies/{id}",
                FieldOfStudy.class,
                student.get().getFieldOfStudyId());
        department = restTemplate.getForObject("http://localhost:8083/api/v1/field-of-studies/{id}/department/{id}",
                Department.class,
                student.get().getId(),
                student.get().getDepartmentId()
        );

        return StudentDTO
                .builder()
                .name(student.get().getName())
                .lastName(student.get().getLastName())
                .gender(student.get().getGender())
                .location(student.get().getLocation())
                .dob(student.get().getDob())
                .fieldOfStudy(fieldOfStudy != null ? fieldOfStudy.getFieldName() : null)
                .departmentName(department != null ? department.getDepartmentName() : null)
                .build();
    }


    /*
     * save the student in the DB
     * */
    public void saveStudent(StudentRegistrationRequest StudentRegistrationRequest) {

    }
}
