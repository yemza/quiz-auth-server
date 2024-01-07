package com.quiz.authserver.securityConfig.keys;


import com.nimbusds.jose.jwk.RSAKey;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.UUID;

public class JwksKeys {

  public static RSAKey generateRsaKey(){

    try {
      KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
      keyPairGenerator.initialize(2048);
      KeyPair key = keyPairGenerator.generateKeyPair();

      RSAPrivateKey privateKey = (RSAPrivateKey) key.getPrivate();
      RSAPublicKey publicKey = (RSAPublicKey) key.getPublic();

    return new RSAKey.Builder(publicKey).privateKey(privateKey).keyID(UUID.randomUUID().toString()).build();
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException("probleme generating key");
    }
  }
}
