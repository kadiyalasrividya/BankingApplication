package com.example.banking.exception;

public class InvalidRequestParameterException extends RuntimeException {
  public InvalidRequestParameterException(String message) {
    super(message);
  }
}
