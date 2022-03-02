package com.interoffice.account.presentation;

import com.interoffice.account.application.AccountFacade;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * temp.
 *
 */
@RestController
@RequiredArgsConstructor
public class AccountApi {

  private final AccountFacade accountFacade;


  @PostMapping(value = "/login")
  public ResponseEntity<Void> login(@RequestBody String id, @RequestBody String password) {
    accountFacade.login(id, password);
    return ResponseEntity.ok().build();
  }


  @PostMapping(value = "/logout")
  public ResponseEntity<Void> logout(HttpSession session) {
    session.invalidate();
    return ResponseEntity.ok().build();
  }

}
