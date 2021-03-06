package com.interoffice.company.presentation.handler;

import com.interoffice.company.domain.exception.CompanyDuplicationException;
import com.interoffice.shared.api.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CompanyExceptionHandler {
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(CompanyDuplicationException.class)
  public ApiResponse<?> handle(CompanyDuplicationException ex) {
    return ApiResponse.fail(
        "BUSINESS_REGISTRATION_NUMBER_DUPLICATED",
        "business registration number is duplicated"
    );
  }

}
