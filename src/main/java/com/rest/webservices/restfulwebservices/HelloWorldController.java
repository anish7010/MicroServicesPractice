package com.rest.webservices.restfulwebservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rest.webservices.restfulwebservices.helloworld.HelloBean;

@RestController
public class HelloWorldController {
  
  @GetMapping("/hello")
  public String hello() {
    return "Hello";
  }
  
  @GetMapping("/hello_bean/{name}")
  public HelloBean helloBean(@PathVariable String name) {
    return new HelloBean("Hello,"+name);
  }
}
