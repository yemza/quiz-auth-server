package com.quiz.authserver.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.Set;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="client")
public class Client {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true)
  private String clientId;
  private Instant clientIdIssuedAt;
  private String clientSecret;
  private Instant clientSecretExpiresAt;
  private String clientName;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "client_authorization_grant_type_mapping" ,
    joinColumns = @JoinColumn(name="client_id"),
    inverseJoinColumns = @JoinColumn(name ="client_authentication_methods_id"))
  private Set<ClientAuthenticationMethod> clientAuthenticationMethods;


  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "client_authentication_methods_mapping",
    joinColumns = @JoinColumn(name = "client_id"),
    inverseJoinColumns = @JoinColumn(name = "client_authentication_methods_id"))
  private Set<AuthorizationGrantType> authorizationGrantTypes;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "client_redirectUris_mapping",
    joinColumns = @JoinColumn(name = "client_id"),
    inverseJoinColumns = @JoinColumn(name="client_redirectUris_id"))
  private Set<RedirectUris> redirectUris;


  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "client_scopes_mapping",
    joinColumns = @JoinColumn(name = "client_id"),
    inverseJoinColumns = @JoinColumn(name="client_scopes_id"))
  private Set<Scopes> scopes;

}
