package com.oyzl.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

  @GetMapping
  public DefaultOAuth2User getUserInfo() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    return (DefaultOAuth2User)authentication.getPrincipal();
  }
}
