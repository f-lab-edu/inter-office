package com.interoffice.account.application.processor.data;

import com.interoffice.account.domain.Account;

public class AccountData {

  private final long id;
  private final String email;

  private final String username;
  private final String phoneNumber;

  public static AccountData from(Account account) {
    return new AccountData(account.getId(), account.getEmail(), account.getUsername(),
        account.getPhoneNumber());
  }

  public AccountData(long id, String email, String username,
      String phoneNumber) {
    this.id = id;
    this.email = email;
    this.username = username;
    this.phoneNumber = phoneNumber;
  }

  public long getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }


  public String getUsername() {
    return username;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }
}
