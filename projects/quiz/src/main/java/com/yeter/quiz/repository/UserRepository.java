package com.yeter.quiz.repository;

import com.yeter.quiz.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository  extends JpaRepository<Users,Long> {
    public List<Users>findByUsername(String username);
}
