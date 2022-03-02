package com.interoffice.account.domain;

import java.util.Optional;

/**
 * temp.
 *
 */
public interface AccountRepository {


  Optional<Account> findById(String id);

}
