package com.devsuperior.dslist.game.exceptions;

import com.devsuperior.dslist.exception.StandardError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GameExceptionHandler {

    @ExceptionHandler(GameNotFoundByIdException.class)
    public ResponseEntity<StandardError> handleGameNotFound(GameNotFoundByIdException exception, HttpServletRequest request) {
        StandardError error = new StandardError();
        error.setTimestamp(Instant.now());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setError("Not Found");
        error.setMessage(exception.getMessage());
        error.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
