package com.excelr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.excelr.model.Enrolled;
import com.excelr.service.EnrolledService;

@RestController
public class EnrolledController {

    @Autowired
    private EnrolledService enrolledService;

    @GetMapping("/api/enrollments")
    public ResponseEntity<?> getAllEnrollments() {
        return enrolledService.getAllEnrollments();
    }

    @GetMapping("/api/enrollment/{id}")
    public ResponseEntity<?> getEnrollment(@PathVariable Integer id) {
        return enrolledService.getEnrollmentById(id);
    }

    @PostMapping("/api/enrollment")
    public ResponseEntity<?> createEnrollment(@RequestBody Enrolled enrolled) {
        return enrolledService.createEnrollment(enrolled);
    }

    @PutMapping("/api/enrollment/{id}")
    public ResponseEntity<?> updateEnrollment(@PathVariable Integer id,
                                              @RequestBody Enrolled enrolled) {
        return enrolledService.updateEnrollment(id, enrolled);
    }

    @DeleteMapping("/api/enrollment/{id}")
    public ResponseEntity<?> deleteEnrollment(@PathVariable Integer id) {
        return enrolledService.deleteEnrollment(id);
    }
}
