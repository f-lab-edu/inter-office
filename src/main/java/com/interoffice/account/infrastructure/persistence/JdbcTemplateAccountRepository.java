package com.interoffice.account.infrastructure.persistence;

import com.interoffice.account.domain.Account;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.time.LocalDateTime;


public class JdbcTemplateAccountRepository {

  private final JdbcTemplate jdbcTemplate;

  public JdbcTemplateAccountRepository(DataSource dataSource) {
    this.jdbcTemplate = new JdbcTemplate(dataSource);
  }

  public Account save(Account account) {
    this.jdbcTemplate.update(
        "insert into users (email, password, username, phonenumber, createdAt, modifiedAt) values (?, ?,?,?,?,?)",
        account.getEmail(), account.getPassword(), account.getUsername(), account.getPhoneNumber(),
        LocalDateTime.now(), LocalDateTime.now());
    return account;
  }

  public Account findByEmail(String email) {
    String sql = "select *  from users where email = ?";
    return jdbcTemplate.queryForObject(sql, new Object[]{email}, (rs, rowNum) ->
        new Account(
            rs.getString("email"),
            rs.getString("password"),
            rs.getString("username"),
            rs.getString("phoneNumber")
        ));
  }

}
