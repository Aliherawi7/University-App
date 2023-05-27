package com.mycompany.fieldofstudyservice.repositories;

import com.mycompany.fieldofstudyservice.models.FieldOfStudy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FieldOfStudyRepository extends JpaRepository<FieldOfStudy, Long> {
}
