package com.yeter.quiz.service;

import com.yeter.quiz.model.Users;
import com.yeter.quiz.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Users createUser(Users user) {

        // Save edir
        return userRepository.save(user);
    }

    public Users getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
    }
//tapmasa excptin  ise dusur deyir user tapilmadi;)

    public Users updateUser(Long id, Users updatedUser) {
        Users user = getUserById(id);

        // Update edir sonrada save edir  yeni formada database-e
        user.setUsername(updatedUser.getUsername());
        user.setPassword(updatedUser.getPassword());
        user.setEmail(updatedUser.getEmail());
        user.setAdmin(updatedUser.isAdmin());
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        Users user = getUserById(id);

        userRepository.delete(user);
    }

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }
}

