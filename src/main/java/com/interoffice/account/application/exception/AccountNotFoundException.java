package com.interoffice.account.application.exception;

public class AccountNotFoundException extends RuntimeException {

  public AccountNotFoundException() {
    super("account not found");
  }
}
