package com.interoffice.account.application.facade;

import com.interoffice.account.application.processor.AccountCreateProcessor;
import com.interoffice.account.application.processor.AccountLoginProcessor;
import com.interoffice.account.application.processor.command.AccountCreateCommand;
import com.interoffice.account.application.processor.command.AccountLoginCommand;
import com.interoffice.account.application.processor.data.AccountData;

public class AccountFacade {

  private final AccountCreateProcessor accountCreateProcessor;
  private final AccountLoginProcessor accountLoginProcessor;


  public AccountFacade(AccountCreateProcessor accountCreateProcessor,
      AccountLoginProcessor accountLoginProcessor) {
    this.accountCreateProcessor = accountCreateProcessor;
    this.accountLoginProcessor = accountLoginProcessor;
  }

  public AccountData createAccount(AccountCreateCommand command) {
    return accountCreateProcessor.execute(command);
  }

  public AccountData loginAccount(AccountLoginCommand command) {
    return accountLoginProcessor.execute(command);
  }


}
