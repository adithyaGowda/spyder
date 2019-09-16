package com.stackroute.squad.exceptions;
/**
 * Custom Exception to throw if Service provider Not Found
 */
public class ServiceProviderNotFound extends Exception {
  private String message;

  public  ServiceProviderNotFound() {
  }

  public  ServiceProviderNotFound(String message) {
    super(message);
    this.message = message;
  }

}
