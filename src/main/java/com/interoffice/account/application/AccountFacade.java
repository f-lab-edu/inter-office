package com.interoffice.account.application;

import com.interoffice.account.domain.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * temp.
 */
@Service
@RequiredArgsConstructor
public class AccountFacade {

  @Autowired
  private final LoginService loginService;

  public void login(String id, String password) {
    loginService.login(id, password);

  }

}


