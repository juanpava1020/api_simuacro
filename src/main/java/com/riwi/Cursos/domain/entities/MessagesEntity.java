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

@Entity(name="messages")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class MessagesEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long messageId;

    // @Column(length = 11)
    // private int senderId;

    // @Column(length = 11)
    // private int receiverId;

    // @Column(length = 11)
    // private int courseId;

    @Lob
    private String messageContent;

    private LocalDate sentDate;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id", referencedColumnName = "userId")
    private UserEntity senderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_id", referencedColumnName = "userId")
    private UserEntity receiverId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", referencedColumnName = "courseId" )
    private CoursesEntity courseId;
}
