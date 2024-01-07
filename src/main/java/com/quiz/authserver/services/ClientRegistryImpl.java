package com.quiz.authserver.services;

import com.quiz.authserver.dao.Client;
import com.quiz.authserver.repository.ClientRepository;
import com.quiz.authserver.securitydao.SecurityClient;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientRegistryImpl implements RegisteredClientRepository {

  private ClientRepository clientRepository;

  @Override
  public void save(RegisteredClient registeredClient) {

  }

  @Override
  public RegisteredClient findById(String id) {
    return null;
  }

  @Override
  public RegisteredClient findByClientId(String clientId) {
    Optional<Client> client = clientRepository.findUserByClientId(clientId);
    return   client.map(SecurityClient::new).orElseThrow(
      () -> new UsernameNotFoundException("Client not found")
    );
  }
}
