package com.interoffice.account.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Account implements Serializable {


  private long id = 0L;

  private final String email;
  private final String password;

  private final String username;
  private final String phoneNumber;

  private final LocalDateTime createdAt;
  private final LocalDateTime modifiedAt;

  public void setId(Long id) {
    this.id = id;
  }

  public Account(String email, String password, String username, String phoneNumber) {
    this.email = email;
    this.password = password;
    this.username = username;
    this.phoneNumber = phoneNumber;
    this.createdAt = LocalDateTime.now();
    this.modifiedAt = this.createdAt;
  }


  public Long getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public String getUsername() {
    return username;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public LocalDateTime getModifiedAt() {
    return modifiedAt;
  }

  public boolean validatePassword(PasswordEncoder passwordEncoder, String password) {
    return this.password.equals(passwordEncoder.encode(password));
  }
}
