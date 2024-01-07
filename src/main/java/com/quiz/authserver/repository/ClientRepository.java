package com.quiz.authserver.repository;

import com.quiz.authserver.dao.Client;
import com.quiz.authserver.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client , Long> {

  @Query(
    "SELECT c FROM Client c WHERE c.clientId = :clientId"
  )
  Optional<Client> findUserByClientId(String clientId);

}
