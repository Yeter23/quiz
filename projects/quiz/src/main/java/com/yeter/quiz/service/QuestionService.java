package com.yeter.quiz.service;

import com.yeter.quiz.model.Questions;
import com.yeter.quiz.repository.QuestionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Questions createQuestion(Questions question) {

        return questionRepository.save(question);
        
    }

    public Questions getQuestionById(Long id) {
        return questionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Question not found"));
        //id-ye gore tapsin tapmasa excp atsin
    }

    public Questions updateQuestion(Long id, Questions updatedQuestion) {
        Questions question = getQuestionById(id);
      //id-ye gore getirenden sonra neleri update ede bilerik yazaq
        question.setQuestionText(updatedQuestion.getQuestionText());
        question.setOption1(updatedQuestion.getOption1());
        question.setOption2(updatedQuestion.getOption2());
        question.setOption3(updatedQuestion.getOption3());
        question.setOption4(updatedQuestion.getOption4());
        question.setCorrectOption(updatedQuestion.getCorrectOption());
        question.setSubject(updatedQuestion.getSubject());
        return questionRepository.save(question);
        // sonda save olunsun
    }

    public void deleteQuestion(Long id) {
        Questions question = getQuestionById(id);
       //burda deyirem ki id ye gore getir sonra da sil
        questionRepository.delete(question);
    }

    public List<Questions> getAllQuestions() {
        return questionRepository.findAll();
        //butun suallari getiren metod
    }
}
