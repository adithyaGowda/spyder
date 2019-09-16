package com.stackroute.teammanagementservice.exception;

/**
 * Custom Exception to throw if title already exists
 */
public class IdeaTitleAlreadyExistException extends Exception {
    private String message;

    public IdeaTitleAlreadyExistException() {

    }

    public IdeaTitleAlreadyExistException(String message) {
        super(message);
        this.message = message;
    }
}
