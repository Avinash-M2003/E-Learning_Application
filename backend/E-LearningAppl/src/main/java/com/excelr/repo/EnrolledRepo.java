package com.excelr.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.excelr.model.Enrolled;
@Repository
public interface EnrolledRepo extends JpaRepository<Enrolled, Integer> {

}
