package com.yeter.quiz.controller;

import com.yeter.quiz.model.Questions;
import com.yeter.quiz.service.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/addquestion")
    public Questions createQuestion(@RequestBody Questions question) {
        return questionService.createQuestion(question);
    }

    @GetMapping("/{id}")
    public Questions getQuestionById(@PathVariable Long id) {
        return questionService.getQuestionById(id);
    }

    @PutMapping("/{id}")
    public Questions updateQuestion(@PathVariable Long id, @RequestBody Questions question) {
        return questionService.updateQuestion(id, question);
    }

    @DeleteMapping("/{id}")
    public void deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
    }

    @GetMapping("/getAllQuestion")
    public List<Questions> getAllQuestions() {

        return questionService.getAllQuestions();
    }
}
