package com.example.pastQuestions.dto;

public record LoginOutputDto(
        String emailAddress,
        String accessToken,
        String refreshToken

) {
}
