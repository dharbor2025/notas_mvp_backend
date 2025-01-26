package com.yacelly.notas_mvp.exception;

public class UserNotAuthenticatedException extends RuntimeException {

  public UserNotAuthenticatedException() {
    super();
  }

  public UserNotAuthenticatedException(String message) {
    super(message);
  }
}
