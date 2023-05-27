package com.mycompany.fieldofstudyservice.controllers;

import com.mycompany.fieldofstudyservice.services.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/field-of-studies")
@AllArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping("{fieldStudyId}/departments")
    public ResponseEntity<?> getAllDepartmentByFieldStudyId(@PathVariable Long fieldStudyId){
        return ResponseEntity.ok(departmentService.getAllDepartmentByFieldStudyId(fieldStudyId));
    }
    @GetMapping("{fieldOfStudyId}/departments/{departmentId}")
    public ResponseEntity<?> getFieldOfStudy(@PathVariable Long fieldOfStudyId, @PathVariable Long departmentId) {
        return ResponseEntity.ok(departmentService.getDepartmentByDepartmentIdAndFieldStudyId(departmentId, fieldOfStudyId));
    }


}
