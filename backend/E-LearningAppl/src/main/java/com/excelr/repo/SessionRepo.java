package com.excelr.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.excelr.model.Session;
@Repository
public interface SessionRepo extends JpaRepository<Session, Integer> {

}
