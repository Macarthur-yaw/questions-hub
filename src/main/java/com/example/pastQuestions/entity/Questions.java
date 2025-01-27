package com.example.pastQuestions.entity;

import com.example.pastQuestions.enums.AnswerSource;
import com.example.pastQuestions.enums.Program;
import com.example.pastQuestions.enums.UserYear;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Questions")
public class Questions {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "content", nullable = false)
    private String content;
    @Column(name = "Subject")
    private String subject;

@Enumerated(EnumType.STRING)
    private UserYear userYear;

@Enumerated(EnumType.STRING)
private Program program;

@Enumerated(EnumType.STRING)
private AnswerSource answerSource;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "answer_id", referencedColumnName = "id")
    private Answers answers;

 @OneToMany(cascade = CascadeType.ALL)
@JoinColumn(name="solutions_id",referencedColumnName = "id")
private List<Solutions> solutions;

@OneToOne(mappedBy = "questions")
private Feedback feedback;

     @ManyToOne
     @JoinColumn(name = "courses_id",referencedColumnName = "id")
    private Courses courses;

}