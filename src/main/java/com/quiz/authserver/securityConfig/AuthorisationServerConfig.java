package com.quiz.authserver.securityConfig;


import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import com.quiz.authserver.securityConfig.keys.JwksKeys;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.OidcScopes;
import org.springframework.security.oauth2.server.authorization.client.InMemoryRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configuration.OAuth2AuthorizationServerConfiguration;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configurers.OAuth2AuthorizationServerConfigurer;
import org.springframework.security.oauth2.server.authorization.settings.AuthorizationServerSettings;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;
import org.springframework.security.oauth2.server.authorization.settings.TokenSettings;
import org.springframework.security.web.SecurityFilterChain;

import java.time.Duration;
import java.util.UUID;

@Configuration
public class AuthorisationServerConfig {



  @Bean
  @Order(Ordered.HIGHEST_PRECEDENCE)
  public SecurityFilterChain authSecurityFilterChain(HttpSecurity http) throws Exception {
    OAuth2AuthorizationServerConfiguration.applyDefaultSecurity(http);
    http.getConfigurer(OAuth2AuthorizationServerConfigurer.class)
      .oidc(Customizer.withDefaults());
    return http.formLogin().and().build();
  }

//  @Bean
//  public RegisteredClientRepository registeredClientRepository() {
//    RegisteredClient registeredClient = RegisteredClient.withId(UUID.randomUUID().toString())
//      .clientId("client")
//      .clientSecret("secret")
//      .scope(OidcScopes.OPENID)
//      .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
//      .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
//      .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
//      .redirectUri("http://127.0.0.1:8080/tokenauth")
//      .clientSettings(ClientSettings.builder()
//        .requireAuthorizationConsent(true).build())
//      .tokenSettings(TokenSettings.builder()
//        .refreshTokenTimeToLive(Duration.ofHours(10))
//        .build())
//      .build();
//
//    return new InMemoryRegisteredClientRepository(registeredClient);
//  }


  // http://localhost:8080/oauth2/authorize?response_type=code&client_id=client&scope=openid&redirect_uri=http://127.0.0.1:8080/tokenauth&code_challenge=ywhRkyF1DMV3dHFg8moDLv_vlVyh6cjaFEopZAG1o-w&code_challenge_method=S256


  @Bean
  public JWKSource<SecurityContext> jwkSource(){
    RSAKey rsaKey = JwksKeys.generateRsaKey();
    JWKSet set = new JWKSet(rsaKey);
    return new ImmutableJWKSet(set);
  }

  @Bean
  public AuthorizationServerSettings authorizationServerSettings() {
    return AuthorizationServerSettings.builder().issuer("http://127.0.0.1:8080").build();
  }
}
