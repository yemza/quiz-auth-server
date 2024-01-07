package com.quiz.authserver.securitydao;

import com.quiz.authserver.dao.Authority;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;


@AllArgsConstructor
public class SecurityAuthority implements GrantedAuthority {
  private Authority authority;

  @Override
  public String getAuthority() {
    return authority.getName();
  }
}
