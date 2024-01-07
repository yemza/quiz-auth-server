package com.quiz.authserver.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="authorization_grant_type")
public class AuthorizationGrantType {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private  Long id;
  private String name;
  @ManyToMany(mappedBy = "authorizationGrantTypes")
  private Set<Client> clients;

}
