package com.quiz.authserver.web;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testAuth {


  @GetMapping("/")
  public String tokenauth(){
    return "tokenauth";
  }

  @GetMapping("/tokenauth")
  public String tokenauth2(){
    return "tokenauth";
  }
}
