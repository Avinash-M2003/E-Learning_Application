package com.excelr.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Session {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
    private String videoUrl;
    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;
    @ManyToOne
    @JoinColumn(name = "batch_id", nullable = false)
    private Batch batch;
}
