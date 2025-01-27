package com.example.pastQuestions.dto;

import com.example.pastQuestions.enums.AnswerSource;
import com.example.pastQuestions.enums.Program;
import com.example.pastQuestions.enums.UserYear;

public record QuestionsDto(
        String title,
        String content,
        String subject,
        UserYear userYear,
        Program program,
        AnswerSource answerSource



) {
}
