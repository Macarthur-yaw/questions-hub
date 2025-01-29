package com.example.pastQuestions.services;
import com.example.pastQuestions.dto.AnswerResponse;
import com.example.pastQuestions.dto.CoursesDto;
import com.example.pastQuestions.dto.QuestionsDto;
import com.example.pastQuestions.dto.UserInputAnswerDto;
import com.example.pastQuestions.entity.Courses;
import com.example.pastQuestions.entity.Questions;
import com.example.pastQuestions.enums.Program;
import com.example.pastQuestions.enums.UserYear;
import com.example.pastQuestions.exceptions.QuestionsNotfoundException;
import com.example.pastQuestions.repository.CoursesRepository;
import com.example.pastQuestions.repository.QuestionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

@Service
public class QuestionsImpl implements QuestionsService {
     QuestionRepository questionRepository;
CoursesRepository coursesRepository;
    @Override


    public Page<QuestionsDto> getAllAvailableCourses(Program program, UserYear userYear,Pageable pageable) {

        Page<QuestionsDto> coursesAvailable=coursesRepository.findAllQuestionsWithProgram(program.name(), userYear.name(), pageable);
        return coursesAvailable;

    }

    @Override
    public Page<QuestionsDto> getQuestionsOfCourses(UUID id) {

        Page<QuestionsDto> questionsResponse=questionRepository.findQuestionsOfCoursesById(id);
        return questionsResponse;

    }

    @Override
    public boolean sendAnswers(UUID id, UserInputAnswerDto userInputAnswerDto) {
        Optional<Questions> questions=questionRepository.findById(id);
        if(questions.isEmpty()){
            throw new QuestionsNotfoundException("questions with that id can not be found");
        }
        Questions questions1=questions.get();
        return (questions1.getAnswers().getAnswer()).equals(userInputAnswerDto.answer());

    }
}
