package com.mycompany.services;

import com.mycompany.dto.StudentReqisterationRequest.StudentRegistrationRequest;
import com.mycompany.models.Student;
import com.mycompany.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentService {

    private  StudentRepository studentRepository;

//    public StudentDTO getStudentDetails(Long id){
//        Optional<StudentRepository> student = studentRepository.findById(id);
//        StudentDTO studentDTO = new StudentDTO();
//        studentDTO.
//    }


    /*
    * save the student in the DB
    * */
    public void saveStudent(StudentRegistrationRequest StudentRegistrationRequest){
        Student student = new Student();
    }
}
