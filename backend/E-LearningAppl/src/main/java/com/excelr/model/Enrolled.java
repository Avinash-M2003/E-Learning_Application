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
public class Enrolled {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "course_id", nullable = false)
	private Course course;
	@ManyToOne
	@JoinColumn(name = "batch_id", nullable = false)
	private Batch batch;
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	private double progress;
    private String enrolledAt;
}
