package com.excelr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/api/session")
    public ResponseEntity<?> createSession(@RequestBody Session session) {
        return sessionService.createSession(session);
    }

    @PutMapping("/api/session/{id}")
    public ResponseEntity<?> updateSession(@PathVariable Integer id,
                                           @RequestBody Session session) {
        return sessionService.updateSession(id, session);
    }

    @DeleteMapping("/api/session/{id}")
    public ResponseEntity<?> deleteSession(@PathVariable Integer id) {
        return sessionService.deleteSession(id);
    }
}
