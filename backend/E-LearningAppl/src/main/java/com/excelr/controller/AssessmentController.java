package com.excelr.controller;

import com.excelr.model.Assessment;
import com.excelr.service.AssessmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AssessmentController {

    @Autowired
    private AssessmentService assessmentService;

    @GetMapping("/api/assessments")
    public ResponseEntity<?> getAllAssessments() {
        return assessmentService.getAllAssessments();
    }

    @GetMapping("/api/assessment/{id}")
    public ResponseEntity<?> getAssessment(@PathVariable Integer id) {
        return assessmentService.getAssessmentById(id);
    }

    @PostMapping("/api/assessment")
    public ResponseEntity<?> addAssessment(@RequestBody Assessment assessment) {
        return assessmentService.addAssessment(assessment);
    }

    @PutMapping("/api/assessment/{id}")
    public ResponseEntity<?> updateAssessment(@PathVariable Integer id,
                                              @RequestBody Assessment assessment) {
        return assessmentService.updateAssessment(id, assessment);
    }

    @DeleteMapping("/api/assessment/{id}")
    public ResponseEntity<?> deleteAssessment(@PathVariable Integer id) {
        return assessmentService.deleteAssessment(id);
    }
}
