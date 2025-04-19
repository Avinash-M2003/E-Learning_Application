package com.excelr.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.excelr.model.Batch;
@Repository
public interface BatchRepo extends JpaRepository<Batch, Integer> {

}
