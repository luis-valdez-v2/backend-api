package com.implancec.controller;

import javax.servlet.http.HttpServletRequest;

import com.implancec.dto.User;
import com.implancec.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService userService;

  public UserController(UserService userService) {
      this.userService = userService;
  }


  @PostMapping("/signin")
  public String login(//
      @RequestParam String username, //
      @RequestParam String password) {
    return userService.signin(username, password);
  }

  @PostMapping("/signup")
  public String signup(@RequestBody User user) {
    System.out.println(user.getUsername());
    return userService.signup(user);
  }

//  @DeleteMapping(value = "/{username}")
//  @PreAuthorize("hasRole('ROLE_ADMIN')")
//  public String delete(@RequestParam("Username") @PathVariable String username) {
//    userService.delete(username);
//    return username;
//  }

//  @GetMapping(value = "/{username}")
//  @PreAuthorize("hasRole('ROLE_ADMIN')")
//  public UserResponseDTO search(@RequestParam("Username") @PathVariable String username) {
//    return modelMapper.map(userService.search(username), UserResponseDTO.class);
//  }

//  @GetMapping(value = "/me")
//  @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
//
//  public UserResponseDTO whoami(HttpServletRequest req) {
//    return modelMapper.map(userService.whoami(req), UserResponseDTO.class);
//  }
//
//  @GetMapping("/refresh")
//  @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
//  public String refresh(HttpServletRequest req) {
//    return userService.refresh(req.getRemoteUser());
//  }

}
