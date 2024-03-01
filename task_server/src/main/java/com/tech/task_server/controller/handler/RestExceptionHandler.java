package com.tech.task_server.controller.handler;

import com.tech.task_server.exception.EntityAlreadyExists;
import com.tech.task_server.exception.NonValidFieldDataException;
import io.jsonwebtoken.MalformedJwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {


    @ExceptionHandler(value = UsernameNotFoundException.class)
    public ResponseEntity<String> usernameNotFoundException(UsernameNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler(value = EntityAlreadyExists.class)
    public ResponseEntity<String> entityAlreadyExists(EntityAlreadyExists exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }
    @ExceptionHandler(value = NonValidFieldDataException.class)
    public ResponseEntity<String> nonValidFieldDataException(NonValidFieldDataException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler(value = MalformedJwtException.class)
    public ResponseEntity<String> malformedJwtException(MalformedJwtException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }
}
