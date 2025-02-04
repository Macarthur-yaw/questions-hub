package com.example.pastQuestions.repository;

import com.example.pastQuestions.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
Optional<User> findByEmailAddress(String emailAddress);
}
