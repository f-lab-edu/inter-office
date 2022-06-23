package com.interoffice.account.application.processor;

import com.interoffice.account.application.processor.command.AccountCreateCommand;
import com.interoffice.account.application.processor.data.AccountData;
import com.interoffice.account.domain.Account;
import com.interoffice.account.domain.PasswordEncoder;
import com.interoffice.account.infrastructure.persistence.AccountRepository;

public class AccountCreateProcessor {

  private final AccountRepository accountRepository;
  private final PasswordEncoder passwordEncoder;

  public AccountCreateProcessor(
      AccountRepository accountRepository,
      PasswordEncoder passwordEncoder) {
    this.accountRepository = accountRepository;
    this.passwordEncoder = passwordEncoder;
  }

  public AccountData execute(AccountCreateCommand command) {

    Account account = new Account(
        command.getEmail(),
        passwordEncoder.encode(command.getPassword()),
        command.getName(),
        command.getPhoneNumber()
    );
    accountRepository.save(account);
    return AccountData.from(account);

  }
}
