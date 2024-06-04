package com.riwi.Cursos.domain.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "assignment")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class AssignmentsEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long assignmentId;

    @Column(nullable = false, length = 100)
    private String assignmentTitle;

    @Lob
    private String description;

    private LocalDate dueDate;

//     @Column(length = 11)
//     private int lessonId;    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lesson_id", referencedColumnName = "lessonId")
    private LessonsEntity lessonId;

     @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
        cascade = CascadeType.ALL,
        fetch = FetchType.EAGER,
        mappedBy = "assignmentId",
        orphanRemoval = false 
    )
    private List<SubmissionsEntity> submission;

}
