package com.interoffice.account.application.processor.command;

public class AccountLoginCommand {

  private final String email;
  private final String password;

  public AccountLoginCommand(String email, String password) {
    this.email = email;
    this.password = password;

  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  @Override
  public String toString() {
    return "AccountLoginCommand{"
        + "email='" + email + '\''
        + ", password='" + password + '\''
        + '}';
  }
}
