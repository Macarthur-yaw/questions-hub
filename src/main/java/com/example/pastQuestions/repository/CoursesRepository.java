package com.example.pastQuestions.repository;

import com.example.pastQuestions.dto.QuestionsDto;
import com.example.pastQuestions.entity.Courses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CoursesRepository extends JpaRepository<Courses, UUID> {
    @Query("Select q From Courses q" + "WHERE (:program IS NULL OR q.program =:program) " +
            "AND (:userYear IS NULL OR q.userYear=:userYear  )" +
            "")
    Page<QuestionsDto> findAllQuestionsWithProgram(
            String program,
            String userYear,
            Pageable pageable
    );

}
