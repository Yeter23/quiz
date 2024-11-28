package com.yeter.quiz.repository;

import com.yeter.quiz.model.UserAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAnswerRepository extends JpaRepository<UserAnswer,Long> {
}
