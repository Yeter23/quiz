package com.yeter.quiz.controller;

import com.yeter.quiz.model.Questions;
import com.yeter.quiz.model.UserAnswer;
import com.yeter.quiz.model.UserAnswersDto;
import com.yeter.quiz.model.Users;
import com.yeter.quiz.repository.QuestionRepository;
import com.yeter.quiz.repository.UserAnswerRepository;
import com.yeter.quiz.repository.UserRepository;
import com.yeter.quiz.service.UserAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-answer")
public class UserAnswerController {
    private final UserAnswerService userAnswerService;

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private QuestionRepository questionRepository;


    @Autowired
    private UserAnswerRepository userAnswerRepository;


    public UserAnswerController(UserAnswerService userAnswerService) {
        this.userAnswerService = userAnswerService;
    }



    @PostMapping
    public UserAnswer createUserAnswer(@RequestBody UserAnswersDto userAnswerDto) {
        Users user = userRepository.findById(userAnswerDto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Questions question = questionRepository.findById(userAnswerDto.getQuestionId())
                .orElseThrow(() -> new IllegalArgumentException("Question not found"));

        UserAnswer userAnswer = new UserAnswer();
        userAnswer.setUsers(user);
        userAnswer.setQuestions(question);
        userAnswer.setSelectedOption(userAnswerDto.getSelectedOption());

        return userAnswerRepository.save(userAnswer);
    }


    @GetMapping("/{id}")
    public UserAnswer getUserAnswerById(@PathVariable Long id) {
        return userAnswerService.getUserAnswerById(id);
    }

    @PutMapping("/{id}")
    public UserAnswer updateUserAnswer(@PathVariable Long id, @RequestBody UserAnswer userAnswer) {
        return userAnswerService.updateUserAnswer(id, userAnswer);
    }

    @DeleteMapping("/{id}")
    public void deleteUserAnswer(@PathVariable Long id) {
        userAnswerService.deleteUserAnswer(id);
    }

    @GetMapping
    public List<UserAnswer> getAllUserAnswers() {
        return userAnswerService.getAllUserAnswers();
    }
}
