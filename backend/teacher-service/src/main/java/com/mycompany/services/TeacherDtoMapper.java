package com.mycompany.services;

import com.mycompany.dtos.TeacherDTO;
import com.mycompany.models.Teacher;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TeacherDtoMapper implements Function<Teacher, TeacherDTO> {

    @Override
    public TeacherDTO apply(Teacher teacher) {
        return TeacherDTO.builder().build();
    }
}
