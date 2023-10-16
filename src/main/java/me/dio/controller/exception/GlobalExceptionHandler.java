package me.dio.controller.exception;

import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {
    
    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleBusinnesException(IllegalArgumentException businnesException) {
        return new ResponseEntity<String>(businnesException.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleNotFoundException(NoSuchElementException notFoundException) {
        return new ResponseEntity<String>("Resource ID not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleUnexpectedException(Throwable unexpectedException) {
        var message = "Unexpected server error, see the logs";
        logger.error(message, unexpectedException);
        return new ResponseEntity<String>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
