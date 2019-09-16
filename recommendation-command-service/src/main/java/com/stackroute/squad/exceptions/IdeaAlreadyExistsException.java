package com.stackroute.squad.exceptions;
/**
 * Custom Exception to throw if idea already exists
 */
public class IdeaAlreadyExistsException extends Exception {
  private String message;

  public IdeaAlreadyExistsException() {
  }

  public IdeaAlreadyExistsException(String message) {
    super(message);
    this.message = message;
  }

}
