package com.example.pastQuestions.dto;

import jakarta.validation.constraints.NotNull;

public record UserSolution(@NotNull String answer_reason, String url) {
}
