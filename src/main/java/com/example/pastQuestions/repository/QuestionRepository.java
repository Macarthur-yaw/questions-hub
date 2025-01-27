package com.example.pastQuestions.repository;

import com.example.pastQuestions.dto.QuestionsDto;
import com.example.pastQuestions.entity.Questions;
import com.example.pastQuestions.enums.Program;
import com.example.pastQuestions.enums.UserYear;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface QuestionRepository extends JpaRepository<Questions, UUID> {

Page<QuestionsDto> findQuestionsOfCoursesById(UUID courses_id);

}
