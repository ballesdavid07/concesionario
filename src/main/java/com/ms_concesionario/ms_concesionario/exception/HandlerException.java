package com.ms_concesionario.ms_concesionario.exception;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestControllerAdvice
public class HandlerException {

    @ExceptionHandler(CarNotFoundException.class)
    public ResponseEntity<?> handleCarNotFound(CarNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<?>> handleValidateException(MethodArgumentNotValidException ex){
        List<String> errors = new ArrayList<>();
        for (FieldError error: ex.getBindingResult().getFieldErrors()){
            String er = error.getField() + " : " + error.getDefaultMessage();
            errors.add(er);
        }
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
