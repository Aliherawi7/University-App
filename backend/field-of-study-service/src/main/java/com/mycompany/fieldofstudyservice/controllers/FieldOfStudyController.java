package com.mycompany.fieldofstudyservice.controllers;

import com.mycompany.fieldofstudyservice.models.FieldOfStudy;
import com.mycompany.fieldofstudyservice.services.DepartmentService;
import com.mycompany.fieldofstudyservice.services.FieldOfStudyService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/field-of-studies")
@AllArgsConstructor
public class FieldOfStudyController {
    private final FieldOfStudyService fieldOfStudyService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getFieldOfStudy(@PathVariable Long id) {
        return ResponseEntity.ok(fieldOfStudyService.getById(id));
    }

    @PostMapping
    public void addFieldOfStudy(FieldOfStudy fieldOfStudy){
        if(fieldOfStudy == null){

        }
        fieldOfStudyService.addFieldOfStudy(fieldOfStudy);
    }





}
