package com.yeter.quiz.repository;

import com.yeter.quiz.model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository  extends JpaRepository<Questions,Long> {

}
