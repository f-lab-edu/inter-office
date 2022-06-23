package com.interoffice.account.application.processor.command;

public class AccountCreateCommand {

  private final String email;
  private final String password;
  private final String name;
  private final String phoneNumber;

  @Override
  public String toString() {
    return "AccountCreateCommand{"
        + "email='" + email + '\''
        + ", password='" + password + '\''
        + ", name='" + name + '\''
        + ", phoneNumber='" + phoneNumber + '\''
        + '}';
  }

  public AccountCreateCommand(String email, String password, String name,
      String phoneNumber) {
    this.email = email;
    this.password = password;
    this.name = name;
    this.phoneNumber = phoneNumber;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public String getName() {
    return name;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }
}
