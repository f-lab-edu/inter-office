package com.interoffice.account.domain;

import org.springframework.stereotype.Component;

/**
 * .
 *
 */
@Component
public interface LoginService {

  void login(String id, String password);

}
