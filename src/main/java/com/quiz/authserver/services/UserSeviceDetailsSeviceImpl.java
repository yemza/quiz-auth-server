package com.quiz.authserver.services;

import com.quiz.authserver.repository.UserRepository;
import com.quiz.authserver.securitydao.SecurityUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserSeviceDetailsSeviceImpl implements UserDetailsService {

  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
   var user =  userRepository.findUserByUsername(username);
    return   user.map(SecurityUser::new).orElseThrow(
     () -> new UsernameNotFoundException("user not found")
   );
  }
}
