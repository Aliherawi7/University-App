package com.mycompany.fieldofstudyservice.services;

import com.mycompany.fieldofstudyservice.exceptions.ResourceNotFoundException;
import com.mycompany.fieldofstudyservice.models.FieldOfStudy;
import com.mycompany.fieldofstudyservice.repositories.FieldOfStudyRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class FieldOfStudyService {
    private final FieldOfStudyRepository fieldOfStudyRepository;


    /* save the field of study in DB */

    public void addFieldOfStudy(FieldOfStudy fieldOfStudy) {
        fieldOfStudyRepository.save(fieldOfStudy);
    }

    public FieldOfStudy getById(long id) {
        log.info("field-of-study fetch with id = {}", id);
        return fieldOfStudyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("field-of-study not found with id: " + id));
    }

}
