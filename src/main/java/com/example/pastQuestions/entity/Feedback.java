package com.example.pastQuestions.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;


    @Column(name = "feedback",nullable = false)
    private String feedback;


    @OneToOne
    @JoinColumn(name = "question_id",referencedColumnName = "id")
    private Questions questions;



}
