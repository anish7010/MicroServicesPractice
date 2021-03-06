package com.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {
  
  @Autowired  
  private UserService userService = new UserService();
  
  @GetMapping("/users")
  public List<User> retrieveAll(){
    return userService.findAll();
  }
  
  @GetMapping("/users/{id}")
  public User retrieveOne(@PathVariable int id) {
    return userService.findUser(id);
  }
  
  @PostMapping("/users")
  public ResponseEntity<Object> addUser(@RequestBody User user) {
    User newUser = userService.save(user);
    URI location = ServletUriComponentsBuilder.
    fromCurrentRequest().
    path("{id}").
    buildAndExpand(user.getId()).toUri();
    
    return ResponseEntity.created(location).build();
  }
}
