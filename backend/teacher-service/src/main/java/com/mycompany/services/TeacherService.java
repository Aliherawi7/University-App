package com.mycompany.services;

import com.mycompany.dtos.TeacherDTO;
import com.mycompany.exceptions.ResourceNotFoundException;
import com.mycompany.models.Teacher;
import com.mycompany.repositories.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final TeacherDtoMapper teacherDtoMapper;


    public void addTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }

    public TeacherDTO getTeacherById(long id){
        Optional<Teacher> teacherOptional = teacherRepository.findById(id);
        if(teacherOptional.isEmpty()){
            throw new ResourceNotFoundException("teacher not found with provided id: "+id);
        }
        return teacherDtoMapper.apply(teacherOptional.get());
    }

}
