package com.interoffice.account.infrastructure.encoder;

import com.interoffice.account.domain.PasswordEncoder;

public class NoOperationPasswordEncoder implements PasswordEncoder {

  @Override
  public String encode(String plainText) {
    return plainText;
  }
}
