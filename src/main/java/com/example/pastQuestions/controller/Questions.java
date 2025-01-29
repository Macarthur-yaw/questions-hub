package com.example.pastQuestions.controller;

import com.example.pastQuestions.dto.QuestionsDto;
import com.example.pastQuestions.dto.UserInputAnswerDto;
import com.example.pastQuestions.enums.Program;
import com.example.pastQuestions.enums.UserYear;
import com.example.pastQuestions.services.QuestionsService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1")
public class Questions {
    QuestionsService questionsService;

    @GetMapping("/courses")
    public ResponseEntity<Page<QuestionsDto>> getAllCourses(
            @RequestParam Program program,
            @RequestParam UserYear userYear,
            Pageable pageable
            ){
return ResponseEntity.ok(questionsService.getAllAvailableCourses(program,userYear,pageable));
    }

    @GetMapping("/courses/questions/{id}")
    public  ResponseEntity<Page<QuestionsDto>> getQuestionsCourses(@PathVariable UUID id){
        return ResponseEntity.ok(questionsService.getQuestionsOfCourses(id));
    }

    @PostMapping("/answers/{id}")
    public  ResponseEntity<Boolean> sendAnswers(@PathVariable UUID id, @Valid @RequestBody UserInputAnswerDto answerDto){
        return ResponseEntity.ok(questionsService.sendAnswers(id,answerDto));
    }








}
