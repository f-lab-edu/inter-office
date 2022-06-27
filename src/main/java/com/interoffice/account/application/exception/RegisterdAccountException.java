package com.interoffice.account.application.exception;

public class RegisterdAccountException extends RuntimeException {

  public RegisterdAccountException() {
    super("email is already registerd");
  }
}
