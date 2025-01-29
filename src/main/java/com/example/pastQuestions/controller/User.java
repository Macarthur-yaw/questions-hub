package com.example.pastQuestions.controller;

import com.example.pastQuestions.dto.UserInputDto;
import com.example.pastQuestions.dto.UserOutputDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class User {


    @PostMapping("/users/login")
    ResponseEntity<String> loginApp(){
        return ResponseEntity.ok("Welcome");
    }

    @PostMapping("/users/register")
    ResponseEntity<UserOutputDto> registerApp(@Valid @RequestBody UserInputDto userInputDto){
        return ResponseEntity.ok("kevin");
    }



}
