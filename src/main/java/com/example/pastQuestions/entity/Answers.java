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
public class Answers {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "answer",nullable = false)
    private String answer;

    @Column(name = "is_correct")
    private Boolean is_correct;

    @Column(name = "answer_source")
    private AnswerSource answerSource;


    @OneToOne(mappedBy = "answers")
    private Questions questions;

}
