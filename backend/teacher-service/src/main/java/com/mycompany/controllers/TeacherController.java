package com.mycompany.controllers;

import com.mycompany.models.Teacher;
import com.mycompany.services.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/teachers")
public class TeacherController {
    private final TeacherService teacherService;

    @PostMapping
    public void addTeacher(@RequestBody Teacher teacher){
        teacherService.addTeacher(teacher);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getTeacherById(@PathVariable long id){
        return ResponseEntity.ok(teacherService.getTeacherById(id));
    }


}
