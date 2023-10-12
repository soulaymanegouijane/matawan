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
/**
 * This class serves as a controller advice for handling custom exceptions and validation errors.
 */
@ControllerAdvice
public class CustomExceptionHandler {
    /**
     * Handles exceptions caused by invalid method arguments ( validation errors ), providing details about validation errors.
     *
     * @param ex The MethodArgumentNotValidException to handle.
     * @return A ProblemDetail containing the HTTP status and validation error details.
     */
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
    /**
     * Handles exceptions related to a team already existing.
     * thrown if a team already exists in the database
     *
     * @param ex The TeamAlreadyExistException to handle.
     * @return A ProblemDetail containing the HTTP status and exception message.
     */
    @ExceptionHandler(TeamAlreadyExistException.class)
    public ProblemDetail handleTeamAlreadyExistException(TeamAlreadyExistException ex) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, ex.getMessage());
    }
}
