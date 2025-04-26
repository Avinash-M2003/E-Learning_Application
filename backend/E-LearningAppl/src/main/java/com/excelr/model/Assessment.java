package com.excelr.model;

import jakarta.persistence.*;

import lombok.Data;

@Entity
@Data
public class Assessment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    @Lob
    private String questionsJson; // could be a JSON string stored in DB

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
