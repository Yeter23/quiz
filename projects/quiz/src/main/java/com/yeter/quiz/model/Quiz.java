package com.yeter.quiz.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String quizName;
    private  String subject;
    @JsonIgnoreProperties("quiz")
    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    private List<QuizQuestion> quizQuestions;


    public Quiz(Long id, String quizName, String subject, List<QuizQuestion> quizQuestions) {
        super();
        this.id = id;
        this.quizName = quizName;
        this.subject = subject;
        this.quizQuestions = quizQuestions;
    }

    public Quiz(String quizName, String subject, List<QuizQuestion> quizQuestions) {
        super();
        this.quizName = quizName;
        this.subject = subject;
        this.quizQuestions = quizQuestions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<QuizQuestion> getQuizQuestions() {
        return quizQuestions;
    }

    public void setQuizQuestions(List<QuizQuestion> quizQuestions) {
        this.quizQuestions = quizQuestions;
    }

    public Quiz() {
        super();
    }

}
