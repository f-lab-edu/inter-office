package com.interoffice.account.presentation.rest;

import com.interoffice.account.application.exception.UnauthorizedException;
import com.interoffice.account.application.facade.AccountFacade;
import com.interoffice.account.application.processor.command.AccountCreateCommand;
import com.interoffice.account.application.processor.command.AccountLoginCommand;
import com.interoffice.account.application.processor.data.AccountData;
import com.interoffice.shared.api.ApiResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/account")
@RestController
public class AccountController {

  private final AccountFacade accountFacade;

  public AccountController(AccountFacade accountFacade) {
    this.accountFacade = accountFacade;
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(path = "/create")
  public ApiResponse<AccountData> createAccount(@RequestBody AccountCreateCommand command) {
    AccountData data = accountFacade.createAccount(command);
    return ApiResponse.success(data);
  }

  @ResponseStatus(HttpStatus.OK)
  @PostMapping(path = "/login")
  public ApiResponse<AccountData> loginAccount(@RequestBody AccountLoginCommand command,
      HttpSession session) {
    AccountData data = accountFacade.loginAccount(command);
    session.setAttribute("loginInfo", data);
    session.setMaxInactiveInterval(1800);
    return ApiResponse.success(data);
  }

  @ResponseStatus(HttpStatus.OK)
  @PostMapping(path = "/logout")
  public ApiResponse<String> logoutAccount(HttpSession session) {
    session.invalidate();
    return ApiResponse.success("로그아웃에 성공하였습니다.");
  }


  //세션이 있어야 하는 APi
  @GetMapping("/temp")
  public ResponseEntity<HttpStatus> redirect(HttpServletRequest request)
      throws UnauthorizedException {

    HttpSession session = request.getSession(false);
    if (null == session) {
      throw new UnauthorizedException("접근할수 없는 url입니다.");
    }
    return new ResponseEntity<>(HttpStatus.OK);
  }

}
