package com.example.pastQuestions.entity;

import com.example.pastQuestions.enums.AnswerSource;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Solutions {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "Explanation",nullable = false)
    private String explanation;

    @ManyToOne
    @JoinColumn(name = "questions_id",referencedColumnName = "id")
    private Questions questions;

    @Enumerated(EnumType.STRING)
private AnswerSource answerSource;

}
