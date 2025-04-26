package com.excelr.service;

import com.excelr.model.Assessment;
import com.excelr.repo.AssessmentRepo;
import com.excelr.model.Course;
import com.excelr.repo.CourseRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AssessmentService {

    @Autowired
    private AssessmentRepo assessmentRepo;

    @Autowired
    private CourseRepo courseRepo;

    public ResponseEntity<?> getAllAssessments() {
        List<Assessment> assessments = assessmentRepo.findAll();
        return ResponseEntity.ok(assessments);
    }

    public ResponseEntity<?> getAssessmentById(Integer id) {
        Optional<Assessment> opt = assessmentRepo.findById(id);
        if (opt.isPresent()) {
            Assessment assessment = opt.get();
            Map<String, Object> response = new HashMap<>();
            response.put("assessment", assessment);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Assessment not found");
        }
    }

    public ResponseEntity<?> addAssessment(Assessment assessment) {
        Optional<Course> course = courseRepo.findById(assessment.getCourse().getId());
        if (course.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid course ID");
        }
        Assessment saved = assessmentRepo.save(assessment);
        Map<String, Object> response = new HashMap<>();
        response.put("assessment", saved);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    public ResponseEntity<?> updateAssessment(Integer id, Assessment updatedAssessment) {
        Optional<Assessment> existing = assessmentRepo.findById(id);
        if (existing.isPresent()) {
            Assessment assessment = existing.get();
            assessment.setTitle(updatedAssessment.getTitle());
            assessment.setQuestionsJson(updatedAssessment.getQuestionsJson());
            assessment.setCourse(updatedAssessment.getCourse());
            assessmentRepo.save(assessment);
            Map<String, Object> response = new HashMap<>();
            response.put("assessment", assessmentRepo.findById(id).orElse(null));
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Assessment not found");
        }
    }

    public ResponseEntity<?> deleteAssessment(Integer id) {
        Optional<Assessment> assessment = assessmentRepo.findById(id);
        if (assessment.isPresent()) {
            assessmentRepo.deleteById(id);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Assessment deleted successfully");
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Assessment not found");
        }
    }
}
