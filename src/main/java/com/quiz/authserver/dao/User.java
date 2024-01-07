package com.quiz.authserver.dao;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true)
  private String username;
  private String fistName;
  private  String lastName;

  @Column(unique = true)
  private String email;
  private  String password;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable( name = "users_authorities"
    ,joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name="authority_id"))
  private  Set<Authority> authorities;

  private boolean accountNonExpired;
  private boolean accountNonLocked;
  private boolean credentialsNonExpired;
  private boolean enabled;

}
