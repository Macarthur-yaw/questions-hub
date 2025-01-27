package com.example.pastQuestions.entity;

import com.example.pastQuestions.enums.Program;
import com.example.pastQuestions.enums.UserYear;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "courses")
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "title",nullable = false)
    private String title;

    @Enumerated(EnumType.STRING)
    private UserYear year;

    @Enumerated(EnumType.STRING)
    private Program program;

    @OneToMany(mappedBy = "courses")
    private List<Questions> questions;

}
