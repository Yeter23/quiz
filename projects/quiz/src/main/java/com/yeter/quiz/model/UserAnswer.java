package com.yeter.quiz.model;

import jakarta.persistence.*;

@Entity
@Table
public class UserAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Questions questions;

    @Column(nullable = false)
    private int selectedOption;

    public UserAnswer(Long id, Users users, Questions questions, int selectedOption) {
        super();
        this.id = id;
        this.users = users;
        this.questions = questions;
        this.selectedOption = selectedOption;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Questions getQuestions() {
        return questions;
    }

    public void setQuestions(Questions questions) {
        this.questions = questions;
    }

    public int getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(int selectedOption) {
        this.selectedOption = selectedOption;
    }

    public UserAnswer() {
        super();
    }
}
