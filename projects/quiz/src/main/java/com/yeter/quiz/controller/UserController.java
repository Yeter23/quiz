package com.yeter.quiz.controller;

import com.yeter.quiz.exc.ErrorResponse;
import com.yeter.quiz.exc.MyExc;
import com.yeter.quiz.model.Users;
import com.yeter.quiz.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.Value;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public Users createUser(@Valid @RequestBody Users user, BindingResult br) {
        if(br.hasErrors()){
            throw new MyExc(new ErrorResponse("validasiya pozuldu",null),br);
        }
        return userService.createUser(user);

    }

    @GetMapping("/{id}")
    public Users getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public Users updateUser(@PathVariable Long id, @RequestBody Users user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @GetMapping
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }
    @ExceptionHandler
    public ErrorResponse handleMyExc(MyExc exc){
        BindingResult br=exc.getBr();
        ErrorResponse mesaj= exc.getMesaj();
        if (br!=null){
            List<FieldError> fieldErrors=br.getFieldErrors();
            mesaj.setFieldErrors(fieldErrors);
        }

        return mesaj;
    }
}
