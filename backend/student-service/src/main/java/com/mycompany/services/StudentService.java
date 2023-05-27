package com.mycompany.services;

import com.mycompany.dto.StudentDTO;
import com.mycompany.dto.StudentRegistrationRequest;
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
        department = restTemplate.getForObject("http://localhost:8083/api/v1/field-of-studies/{fieldStudyId}/departments/{departmentId}",
                Department.class,
                student.get().getFieldOfStudyId(),
                student.get().getDepartmentId()
        );

        return StudentDTO
                .builder()
                .name(student.get().getName())
                .lastName(student.get().getLastName())
                .gender(student.get().getGender())
                .email(student.get().getEmail())
                .joinedDate(student.get().getJoinedDate())
                .nationality(student.get().getNationality())
                .imageUrl("image url")
                .location(student.get().getLocation())
                .dob(student.get().getDob())
                .phoneNumber(student.get().getPhoneNumber())
                .nationalId(student.get().getNationalId())
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
