package com.example.pastQuestions.dto;

import java.util.UUID;

public record UserOutputDto(
        String firstName,
        String middleName,
        String lastName,
        String emailAddress,
        String role,
        UUID id,
        String accessToken,
        String refreshToken
) {
}
