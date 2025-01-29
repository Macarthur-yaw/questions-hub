package com.example.pastQuestions.repository;

import com.example.pastQuestions.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
Optional<User> findByEmailAddress(String emailAddress);
}
