package com.interoffice.account.infrastructure;

import com.interoffice.account.domain.Account;
import lombok.Getter;
import lombok.Setter;

/**
 * .
 *
 */
@Getter
@Setter
public class LoginSessionInfo {
  
  private Role role;
  private long id; 


  public LoginSessionInfo(Account account) {
    this.role = account.getRole();
    this.id = account.getId();
  }
}

