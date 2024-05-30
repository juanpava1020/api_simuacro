package com.riwi.Cursos.domain.entities;

import java.time.LocalDate;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "submissions")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class SubmissionsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long submissionId;
    @Lob
    private String content;
    private LocalDate submissionDate;
    private double grade;
    @Column(length = 11)
    private int userId;
    @Column(length = 11)
    private int assignmentId;
    
}
