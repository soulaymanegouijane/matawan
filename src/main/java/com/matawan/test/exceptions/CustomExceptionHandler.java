package com.matawan.test.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handlValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> details = new HashMap<>();
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        for(FieldError error :fieldErrors ) {
            details.put(error.getField(),error.getDefaultMessage());
        }
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, details.toString());
    }

    @ExceptionHandler(TeamAlreadyExistException.class)
    public ProblemDetail handleTeamAlreadyExistException(TeamAlreadyExistException ex) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, ex.getMessage());
    }
}
