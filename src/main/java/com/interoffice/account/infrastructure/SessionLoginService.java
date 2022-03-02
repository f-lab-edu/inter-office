package com.interoffice.account.infrastructure;

import com.interoffice.account.domain.Account;
import com.interoffice.account.domain.AccountRepository;
import com.interoffice.account.domain.LoginService;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * .
 *
 */
@RequiredArgsConstructor
@Getter

@Component
public class SessionLoginService implements LoginService {

  private HttpSession session;
  private AccountRepository accountRepository;

  /**
   * .
   */
  public void login(String id, String password) {

    if (session.getAttribute("loginSessionInfo") != null) {
      new IllegalStateException("이미 로그인 상태");
    } else {
      Account account = accountRepository.findById(id)
          .orElseThrow(() -> new IllegalStateException("존재하지 않는 아이디입니다."));

      if (password != account.getPassword()) {
        throw new IllegalStateException("패스워드가 맞지 않습니다. ");
      }

      session.setAttribute("loginSessionInfo", new LoginSessionInfo(account));
    }

  }

}
