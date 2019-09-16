package com.stackroute.squad.exceptions;
/**
 * Custom Exception to throw if idea not found
 */
public class IdeaNotFoundException extends Exception{
  private String message;

  public IdeaNotFoundException() {
  }

  public IdeaNotFoundException(String message) {
    super(message);
    this.message = message;
  }
}
