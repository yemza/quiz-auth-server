package com.quiz.authserver.securitydao;


import com.quiz.authserver.dao.Client;
import lombok.AllArgsConstructor;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;
import org.springframework.security.oauth2.server.authorization.settings.TokenSettings;

import java.time.Duration;
import java.time.Instant;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
public class SecurityClient extends RegisteredClient {

  private Client client;

  @Override
  public String getId() {
    return client.getId().toString();
  }

  @Override
  public String getClientId() {
    return client.getClientId();
  }

  @Override
  public Instant getClientIdIssuedAt() {
    return client.getClientIdIssuedAt();
  }

  @Override
  public String getClientSecret() {
    return client.getClientSecret();
  }

  @Override
  public Instant getClientSecretExpiresAt() {
    return client.getClientSecretExpiresAt();
  }

  @Override
  public String getClientName() {
    return client.getClientName();
  }

  @Override
  public Set<ClientAuthenticationMethod> getClientAuthenticationMethods() {
    return  client.getClientAuthenticationMethods()
      .stream().map( cl -> new ClientAuthenticationMethod(cl.getName()))
      .collect(Collectors.toSet());

  }

  @Override
  public Set<AuthorizationGrantType> getAuthorizationGrantTypes() {
    return  client.getAuthorizationGrantTypes()
      .stream().map( cl -> new AuthorizationGrantType(cl.getName()))
      .collect(Collectors.toSet());
  }

  @Override
  public Set<String> getRedirectUris() {
    return  client.getRedirectUris()
      .stream().map( cl -> cl.getName())
      .collect(Collectors.toSet());
  }

  @Override
  public Set<String> getScopes() {
    return  client.getScopes()
      .stream().map( cl -> cl.getName())
      .collect(Collectors.toSet());
  }

  @Override
  public ClientSettings getClientSettings() {
    return ClientSettings.builder()
      .requireAuthorizationConsent(true).build();
  }

  @Override
  public TokenSettings getTokenSettings() {
    return TokenSettings.builder()
      .refreshTokenTimeToLive(Duration.ofHours(10))
      .build();
  }
}
