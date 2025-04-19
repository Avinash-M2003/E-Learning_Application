package com.excelr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.excelr.model.Course;
import com.excelr.service.CourseService;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/api/courses")
    public ResponseEntity<?> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/api/course/{id}")
    public ResponseEntity<?> getCourse(@PathVariable Integer id) {
        return courseService.getCourseById(id);
    }

    @PostMapping(value = "/api/course", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> createCourse(@RequestPart Course course,
                                          @RequestPart("image") MultipartFile image) {
        return ResponseEntity.ok(courseService.createCourse(course, image));
    }

    @PutMapping(value = "/api/course/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> updateCourse(@PathVariable Integer id,
                                          @RequestPart Course course,
                                          @RequestPart(name = "image", required = false) MultipartFile image) {
        return courseService.updateCourse(id, course, image);
    }

    @DeleteMapping("/api/course/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Integer id) {
        return courseService.deleteCourse(id);
    }
}
