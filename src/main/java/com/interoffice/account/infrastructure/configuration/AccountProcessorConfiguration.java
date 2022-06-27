package com.interoffice.account.infrastructure.configuration;

import com.interoffice.account.application.processor.AccountCreateProcessor;
import com.interoffice.account.application.processor.AccountLoginProcessor;
import com.interoffice.account.domain.PasswordEncoder;
import com.interoffice.account.infrastructure.persistence.AccountRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountProcessorConfiguration {


  @Bean
  public AccountCreateProcessor accountCreateProcessor(AccountRepository accountRepository,
      PasswordEncoder passwordEncoder) {
    return new AccountCreateProcessor(accountRepository, passwordEncoder);
  }

  @Bean
  public AccountLoginProcessor accountLoginProcessor(
      AccountRepository accountRepository,
      PasswordEncoder passwordEncoder) {
    return new AccountLoginProcessor(accountRepository, passwordEncoder);
  }


}
