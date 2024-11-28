package com.yeter.quiz.service;

import com.yeter.quiz.model.UserAnswer;
import com.yeter.quiz.repository.UserAnswerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAnswerService {
    private final UserAnswerRepository userAnswerRepository;

    public UserAnswerService(UserAnswerRepository userAnswerRepository) {
        this.userAnswerRepository = userAnswerRepository;
    }

    public UserAnswer createUserAnswer(UserAnswer userAnswer) {

        return userAnswerRepository.save(userAnswer);
    }

    public UserAnswer getUserAnswerById(Long id) {
        return userAnswerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User Answer not found"));
    }

    public UserAnswer updateUserAnswer(Long id, UserAnswer updatedUserAnswer) {
        UserAnswer userAnswer = getUserAnswerById(id);
        userAnswer.setUsers(updatedUserAnswer.getUsers());
        userAnswer.setQuestions(updatedUserAnswer.getQuestions());
        userAnswer.setSelectedOption(updatedUserAnswer.getSelectedOption());
        return userAnswerRepository.save(userAnswer);
    }

    public void deleteUserAnswer(Long id) {
        UserAnswer userAnswer = getUserAnswerById(id);

        userAnswerRepository.delete(userAnswer);
    }

    public List<UserAnswer> getAllUserAnswers() {
        return userAnswerRepository.findAll();
    }
}
