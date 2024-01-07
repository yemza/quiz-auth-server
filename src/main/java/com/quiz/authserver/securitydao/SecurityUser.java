package com.quiz.authserver.securitydao;

import com.quiz.authserver.dao.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

@AllArgsConstructor
public class SecurityUser implements UserDetails {

  private User user;

  @Override
  public String getUsername() {
    return user.getUsername();
  }
  @Override
  public String getPassword() {
    return user.getPassword();
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {

    return  user.getAuthorities()
      .stream()
      .map(SecurityAuthority::new)
      .collect(Collectors.toList());
  }

  @Override
  public boolean isAccountNonExpired() {
    return user.isAccountNonExpired();
  }

  @Override
  public boolean isAccountNonLocked() {
    return user.isAccountNonLocked();
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return user.isCredentialsNonExpired();
  }

  @Override
  public boolean isEnabled() {
    return user.isEnabled();
  }
}
