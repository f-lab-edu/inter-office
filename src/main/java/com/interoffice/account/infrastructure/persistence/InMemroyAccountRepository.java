package com.interoffice.account.infrastructure.persistence;

import com.interoffice.account.domain.Account;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;


public class InMemroyAccountRepository {


  private final AtomicLong atomicLong = new AtomicLong(1L);
  private final Map<Long, Account> accountMap = new ConcurrentHashMap<>();

  public Account save(Account account) {
    if (account.getId() == 0) {
      long id = atomicLong.getAndIncrement();
      account.setId(id);
    }
    return accountMap.put(account.getId(), account);
  }

  public Account findByEmail(String email) {

    return accountMap
        .values()
        .stream()
        .filter(account -> account.getEmail().equals(email))
        .findFirst()
        .orElse(null);
  }

}
