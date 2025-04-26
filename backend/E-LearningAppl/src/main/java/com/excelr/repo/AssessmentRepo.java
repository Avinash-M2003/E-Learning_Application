package com.excelr.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.excelr.model.Assessment;

@Repository
public interface AssessmentRepo extends JpaRepository<Assessment, Integer> {

}
