package com.interoffice.account.infrastructure.configuration;

import com.interoffice.account.infrastructure.persistence.AccountRepository;
import com.interoffice.account.infrastructure.persistence.AccountRepositoryAdapter;
import com.interoffice.account.infrastructure.persistence.InMemroyAccountRepository;
import com.interoffice.account.infrastructure.persistence.JdbcTemplateAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class AccountRepositoryConfiguration {

  @Autowired
  private DataSource dataSource;

  @Bean
  public AccountRepository accountRepository(
      JdbcTemplateAccountRepository jdbcTemplateAccountRepository) {
    return new AccountRepositoryAdapter(jdbcTemplateAccountRepository);
  }

  @Bean
  public InMemroyAccountRepository inMemroyAccountRepository() {
    return new InMemroyAccountRepository();
  }

  @Bean
  public JdbcTemplateAccountRepository jdbcTemplateAccountRepository() {
    return new JdbcTemplateAccountRepository(dataSource);
  }
}
