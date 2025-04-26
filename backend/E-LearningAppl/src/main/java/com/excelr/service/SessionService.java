package com.excelr.service;

import com.excelr.model.Session;
import com.excelr.repo.SessionRepo;
import com.excelr.util.S3Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Service
public class SessionService {

    @Autowired
    private SessionRepo sessionRepo;

    @Autowired
    private S3Util s3Util;

    public ResponseEntity<?> getAllSessions() {
        List<Session> sessions = sessionRepo.findAll();
        Map<String, Object> response = new HashMap<>();
        response.put("sessions", sessions);
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<?> getSessionById(Integer id) {
        Optional<Session> sessionOpt = sessionRepo.findById(id);
        if (sessionOpt.isPresent()) {
            Map<String, Object> response = new HashMap<>();
            response.put("session", sessionOpt.get());
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Session not found");
        }
    }

    public ResponseEntity<?> createSession(Session session, MultipartFile videoFile) {
        try {
            if (videoFile != null && !videoFile.isEmpty()) {
                String videoUrl = s3Util.uploadFile(videoFile);
                session.setVideoUrl(videoUrl);
            }

            Session saved = sessionRepo.save(session);
            Map<String, Object> response = new HashMap<>();
            response.put("session", saved);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to create session: " + e.getMessage());
        }
    }

    public ResponseEntity<?> updateSession(Integer id, Session updatedSession, MultipartFile newVideo) {
        Optional<Session> sessionOpt = sessionRepo.findById(id);
        if (sessionOpt.isPresent()) {
            Session session = sessionOpt.get();

            session.setTitle(updatedSession.getTitle());
            session.setCourse(updatedSession.getCourse());
            session.setBatch(updatedSession.getBatch());

            if (newVideo != null && !newVideo.isEmpty()) {
                String updatedUrl = s3Util.updateFile(session.getVideoUrl(), newVideo);
                session.setVideoUrl(updatedUrl);
            }

            sessionRepo.save(session);

            Map<String, Object> response = new HashMap<>();
            response.put("session", session);
            return ResponseEntity.ok(response);

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Session not found");
        }
    }

    public ResponseEntity<?> deleteSession(Integer id) {
        Optional<Session> sessionOpt = sessionRepo.findById(id);
        if (sessionOpt.isPresent()) {
            Session session = sessionOpt.get();

            if (session.getVideoUrl() != null) {
                s3Util.deleteFile(session.getVideoUrl());
            }

            sessionRepo.deleteById(id);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Session deleted successfully");
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Session not found");
        }
    }
}
