package com.yeter.quiz.repository;

import com.yeter.quiz.model.Quiz;
import com.yeter.quiz.model.QuizQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizQuestionRepository extends JpaRepository<QuizQuestion,Long> {
    public List<QuizQuestion>findByQuiz(Quiz quiz);
}
