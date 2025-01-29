package com.example.pastQuestions.dto;

import jakarta.validation.constraints.NotNull;

public record UserInputDto(
        @NotNull  String firstName,
        String middleName,
        @NotNull  String lastName,
       @NotNull String emailAddress,
       @NotNull String password
                           ) {
}
