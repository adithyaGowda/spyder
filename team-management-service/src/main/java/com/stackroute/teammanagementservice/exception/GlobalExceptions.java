package com.stackroute.teammanagementservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @ControllerAdvice annotation provided by Spring allows you to write global
 * code that can be applied to a wide range of controllers
 */
@ControllerAdvice
public class GlobalExceptions {

    /**
     * Handles IdeaTitleAlreadyExistException
     */
    @ExceptionHandler(IdeaTitleAlreadyExistException.class)
    public ResponseEntity<?> titleAlreadyExists(IdeaTitleAlreadyExistException ex){
        return new ResponseEntity<String>("Title Alreday Exists", HttpStatus.CONFLICT);
    }
}
