package com.interoffice.account.presentation.handler;

import com.interoffice.account.application.exception.AccountNotFoundException;
import com.interoffice.account.application.exception.NotEqualPasswordException;
import com.interoffice.account.application.exception.RegisterdAccountException;
import com.interoffice.account.application.exception.UnauthorizedException;
import com.interoffice.shared.api.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AccountExceptionHandler {

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(RegisterdAccountException.class)
  public ApiResponse<?> handleRegisterdAccountException() {
    return ApiResponse.fail("4000", "이미 등록된 이메일입니다. ");
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(AccountNotFoundException.class)
  public ApiResponse<?> handleAccountNotFoundException() {
    return ApiResponse.fail("4001", "이메일을 찾을 수 없습니다.  ");
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(NotEqualPasswordException.class)
  public ApiResponse<?> handleNotEqualPasswordException() {
    return ApiResponse.fail("4001", "입력하신 정보가 서버에 등록된 계정정보와 일치하지 않습니다.");
  }

  @ResponseStatus(HttpStatus.UNAUTHORIZED)
  @ExceptionHandler(UnauthorizedException.class)
  public ApiResponse<?> handleUnauthorizedException() {
    return ApiResponse.fail("4002", "접근할수 없는 url입니다.");
  }
}

