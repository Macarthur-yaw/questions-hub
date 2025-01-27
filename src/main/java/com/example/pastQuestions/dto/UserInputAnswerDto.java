package com.example.pastQuestions.dto;


import jakarta.validation.constraints.NotNull;

public record UserInputAnswerDto(@NotNull String answer) {
}
