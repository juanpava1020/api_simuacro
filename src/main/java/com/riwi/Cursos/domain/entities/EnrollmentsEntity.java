package com.riwi.Cursos.domain.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "enrollment")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class EnrollmentsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long enrollmentId;

    // @Column(length = 11)
    // private int userId;

    // @Column(length = 11)
    // private int courseId;

    @Column(nullable = false)
    private LocalDate enrollmentDate;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name =  "user_id", referencedColumnName = "userId")
    private UserEntity userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courses_id", referencedColumnName = "courseId")
    private CoursesEntity courseId;

}
