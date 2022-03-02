package com.interoffice.account.infrastructure;

import com.interoffice.account.domain.Account;
import com.interoffice.account.domain.AccountRepository;
import java.util.Optional;
import org.springframework.stereotype.Repository;

/**
 * temp.
 *
 */
@Repository
public class MybatisAccountRepository implements AccountRepository  {


  public Optional<Account> findById(String id) {
    return null;
  }

}
