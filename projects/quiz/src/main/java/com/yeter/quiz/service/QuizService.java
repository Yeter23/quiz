package com.yeter.quiz.service;

import com.yeter.quiz.model.Questions;
import com.yeter.quiz.model.Quiz;
import com.yeter.quiz.model.QuizQuestion;
import com.yeter.quiz.repository.QuestionRepository;
import com.yeter.quiz.repository.QuizQuestionRepository;
import com.yeter.quiz.repository.QuizRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    private final QuizRepository quizRepository;

    @Autowired
    private QuizQuestionRepository quizQuestionRepository;

    @Autowired
    private QuestionRepository questRepository;


    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public Quiz createQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    public Quiz getQuizById(Long id) {
        return quizRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Quiz not found"));
    }

    public Quiz updateQuiz(Long id, Quiz updatedQuiz) {
        Quiz quiz = getQuizById(id);

        quiz.setQuizName(updatedQuiz.getQuizName());
        quiz.setSubject(updatedQuiz.getSubject());
        return quizRepository.save(quiz);
    }

    public void deleteQuiz(Long id) {
        Quiz quiz = getQuizById(id);
        quizRepository.delete(quiz);
    }

    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    public List<Questions> getQuizQuestById(Long id){
        System.out.println("Id"+id);
        List<QuizQuestion> quizQuesList =  quizQuestionRepository.findByQuiz(getQuizById(id));
        List<Questions> questionList = new ArrayList<>();
        for(QuizQuestion quizQues: quizQuesList) {
            Optional<Questions> optionalQuestions = questRepository.findById(quizQues.getQuestion().getId());
            optionalQuestions.ifPresent(questionList::add);
        }


        return questionList;
    }
}
