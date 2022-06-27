package com.interoffice.account.infrastructure.configuration;

import com.interoffice.account.domain.PasswordEncoder;
import com.interoffice.account.infrastructure.encoder.SHA256PasswordEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PasswordEncoderConfiguration {

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new SHA256PasswordEncoder();
  }


}
