package com.example.pastQuestions.services;

import com.example.pastQuestions.dto.LoginOutputDto;
import com.example.pastQuestions.dto.LoginRequestDto;
import com.example.pastQuestions.dto.UserInputDto;
import com.example.pastQuestions.dto.UserOutputDto;

public interface UserService {
    UserOutputDto registerUser(UserInputDto userInputDto);

    LoginOutputDto loginUser(LoginRequestDto loginRequestDto);

}
