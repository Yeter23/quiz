package com.yeter.quiz.exc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.validation.BindingResult;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class MyExc extends RuntimeException {
    private ErrorResponse mesaj;
    private BindingResult br;

}
