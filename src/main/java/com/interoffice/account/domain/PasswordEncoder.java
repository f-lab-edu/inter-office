package com.interoffice.account.domain;

public interface PasswordEncoder {

  String encode(String plainText);
}
