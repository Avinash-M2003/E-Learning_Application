package com.excelr.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.excelr.model.Course;
@Repository
public interface CourseRepo extends JpaRepository<Course, Integer> {

}
