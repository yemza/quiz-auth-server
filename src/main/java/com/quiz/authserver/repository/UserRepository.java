package com.quiz.authserver.repository;

import com.quiz.authserver.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User , Long> {


  @Query(
    "SELECT u FROM User u WHERE u.username = :username"
  )
 Optional<User> findUserByUsername(String username);


}


