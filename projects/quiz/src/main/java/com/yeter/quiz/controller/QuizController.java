package com.yeter.quiz.controller;

import com.yeter.quiz.model.Questions;
import com.yeter.quiz.model.Quiz;
import com.yeter.quiz.model.QuizQuestion;
import com.yeter.quiz.service.QuizService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quizs")
public class QuizController {
    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }



    @PostMapping
    public Quiz createQuiz(@RequestBody Quiz quiz) {
        List<QuizQuestion> quizQuestions = quiz.getQuizQuestions();
        for (QuizQuestion quizQuestion : quizQuestions) {
            quizQuestion.setQuiz(quiz); // Set the quiz for each quiz question
        }
        return quizService.createQuiz(quiz);
    }

    @GetMapping("/{id}")
    public Quiz getQuizById(@PathVariable Long id) {
        return quizService.getQuizById(id);
    }

    @PutMapping("/{id}")
    public Quiz updateQuiz(@PathVariable Long id, @RequestBody Quiz quiz) {
        return quizService.updateQuiz(id, quiz);
    }

    @DeleteMapping("/{id}")
    public void deleteQuiz(@PathVariable Long id) {
        quizService.deleteQuiz(id);
    }

    @GetMapping
    public List<Quiz> getAllQuizzes() {
        return quizService.getAllQuizzes();
    }

    @GetMapping("/getQuizQuestById/{id}")
    public List<Questions> getQuizQuestById(@PathVariable Long id){

        return quizService.getQuizQuestById(id);
    }
}
