package com.mycompany.fieldofstudyservice.services;

import com.mycompany.fieldofstudyservice.exceptions.ResourceNotFoundException;
import com.mycompany.fieldofstudyservice.models.Department;
import com.mycompany.fieldofstudyservice.repositories.DepartmentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public void save(Department department) {
        departmentRepository.save(department);
    }

    public Department getDepartmentByDepartmentIdAndFieldStudyId(long depId, long fieldStudyId) {
        log.info("department not found with provided field id: {} and department id: {}", depId, depId);
        return departmentRepository.findDepartmentByIdAndFieldOfStudyId(depId, fieldStudyId)
                .orElseThrow(() -> new ResourceNotFoundException("department not found with provided id: " + depId));
    }

    public List<Department> getAllDepartmentByFieldStudyId(Long fieldStudyId){
        return departmentRepository.findAllByFieldOfStudyId(fieldStudyId);
    }
}

