package com.excelr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.excelr.model.Session;
import com.excelr.service.SessionService;

@RestController
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @GetMapping("/api/sessions")
    public ResponseEntity<?> getAllSessions() {
        return sessionService.getAllSessions();
    }

    @GetMapping("/api/session/{id}")
    public ResponseEntity<?> getSession(@PathVariable Integer id) {
        return sessionService.getSessionById(id);
    }

    @PostMapping(value="/api/session", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> createSession(@RequestPart Session session, 
    									   @RequestPart("video") MultipartFile videoFile) {
        return sessionService.createSession(session, videoFile);
    }

    @PutMapping(value= "/api/session/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> updateSession(@PathVariable Integer id,
                                           @RequestPart Session session,
                                           @RequestPart("video") MultipartFile videoFile) {
        return sessionService.updateSession(id, session, videoFile);
    }

    @DeleteMapping("/api/session/{id}")
    public ResponseEntity<?> deleteSession(@PathVariable Integer id) {
        return sessionService.deleteSession(id);
    }
}
