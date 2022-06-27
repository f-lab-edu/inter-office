package com.interoffice.account.infrastructure.persistence;

import com.interoffice.account.domain.Account;

public interface AccountRepository {

  Account save(Account account);

  Account findByEmail(String email);

}
