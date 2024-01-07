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
@Table(name="client_authentication_method")
public class ClientAuthenticationMethod {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private  Long id;
  private String name;

  @ManyToMany(mappedBy = "clientAuthenticationMethods")
  private Set<Client> clients;

}
