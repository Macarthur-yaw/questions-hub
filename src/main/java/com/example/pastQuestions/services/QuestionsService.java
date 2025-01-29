package com.example.pastQuestions.services;

import com.example.pastQuestions.dto.AnswerResponse;
import com.example.pastQuestions.dto.QuestionsDto;
import com.example.pastQuestions.dto.UserInputAnswerDto;
import com.example.pastQuestions.enums.Program;
import com.example.pastQuestions.enums.UserYear;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;


public interface QuestionsService {

    public Page<QuestionsDto> getAllAvailableCourses(Program program, UserYear userYear, Pageable pageable);

    public Page<QuestionsDto> getQuestionsOfCourses(UUID id);

    public boolean sendAnswers(UUID id, UserInputAnswerDto userInputAnswerDto);
}
