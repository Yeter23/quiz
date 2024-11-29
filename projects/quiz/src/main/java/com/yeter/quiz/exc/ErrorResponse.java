package com.yeter.quiz.exc;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.validation.FieldError;

import java.util.List;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private String message;
    List<FieldError> fieldErrors;

}
