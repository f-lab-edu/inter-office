package com.interoffice.account.infrastructure.configuration;

import com.interoffice.account.application.facade.AccountFacade;
import com.interoffice.account.application.processor.AccountCreateProcessor;
import com.interoffice.account.application.processor.AccountLoginProcessor;
import com.interoffice.account.domain.PasswordEncoder;
import com.interoffice.account.infrastructure.persistence.AccountRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountFacadeConfiguration {

  AccountRepository accountRepository;
  PasswordEncoder passwordEncoder;

  @Bean
  public AccountFacade accountFacade(
      AccountCreateProcessor accountCreateProcessor,
      AccountLoginProcessor accountLoginProcessor) {
    return new AccountFacade(accountCreateProcessor, accountLoginProcessor);
  }

  @Bean
  public AccountCreateProcessor accountCreateProcessor() {
    return new AccountCreateProcessor(accountRepository,
        passwordEncoder);
  }

  @Bean
  public AccountLoginProcessor accountLoginProcessor() {
    return new AccountLoginProcessor(accountRepository, passwordEncoder);
  }

}

