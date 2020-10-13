package oit.is.lec03_4.security.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class Sample3AuthConfiguration extends WebSecurityConfigurerAdapter{

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception{
    auth.inMemoryAuthentication().withUser("user1").password(passwordEncoder().encode("pAssw0rd")).roles("USER");
    auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder().encode("pAssw0rd")).roles("ADMIN");
  }
  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }




}
