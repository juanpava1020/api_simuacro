package com.riwi.Cursos.domain.entities;

import java.time.LocalDate;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
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

    // @Column(length = 11)
    // private int userId;
    // @Column(length = 11)
    // private int assignmentId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private UserEntity userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assignment_id", referencedColumnName = "assignmentId")
    private AssignmentsEntity assignmentId;
}
