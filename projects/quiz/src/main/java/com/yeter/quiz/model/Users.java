package com.yeter.quiz.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long  id;
private String username;
private String password;
private String email;
private  boolean isAdmin;
    public Users(Long id, String username, String password, String email, boolean isAdmin) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.isAdmin = isAdmin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Users() {
        super();
    }
}
