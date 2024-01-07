package com.quiz.authserver.securityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {


  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
     http.formLogin()
       .and()
       .authorizeHttpRequests().anyRequest().authenticated();
    return http.build();
  }

  @Bean
  public PasswordEncoder passwordEncoder(){
    //return NoOpPasswordEncoder.getInstance(); //To be deleted
    return  new BCryptPasswordEncoder();
  }

/*  @Bean
  public UserDetailsService userDetailsService()
  {
    var u1 = User.withUsername("hamza")
        .password("hamza")
        .authorities("read").build();

    return  new InMemoryUserDetailsManager(u1);
  }*/
}
