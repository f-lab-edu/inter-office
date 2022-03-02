package com.interoffice.account.domain;

import com.interoffice.account.infrastructure.Role;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;

/**
 * .
 *
 */
@Getter
public class Account implements Serializable {

  private Long id;
  private String username;
  private String email;
  private String password;
  private LocalDateTime createdAt;
  private LocalDateTime modifiedAt;
  private Role role;

}
