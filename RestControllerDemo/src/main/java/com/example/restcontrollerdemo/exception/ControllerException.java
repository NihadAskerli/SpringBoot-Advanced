package com.example.restcontrollerdemo.exception;

import com.example.restcontrollerdemo.exception.type.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerException {
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<String> unexpected(){
//      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Server Error");
//    }
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<?> notFound(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(NotFoundException.of());
    }
}
